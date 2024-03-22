package br.com.fiap.hackathon.time.tracking.driven.mongo.config;

import br.com.fiap.tech.challenge.exception.ApplicationException;
import io.awspring.cloud.s3.S3Template;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.stream.Stream;

import static br.com.fiap.hackathon.time.tracking.enterprise.error.ApplicationError.UNKNOWN_ERROR;
import static java.util.stream.Collectors.toUnmodifiableSet;


@RequiredArgsConstructor
class SSLLoaderImpl implements SSLLoader{

    private static final String END_OF_CERTIFICATE_DELIMITER = "-----END CERTIFICATE-----";

    private static final String CERTIFICATE_TYPE = "X.509";

    private static final String TLS_PROTOCOL = "TLS";

    @Value("${" + EnvironmentProperties.MONGO_SSL_BUCKET + "}")
    private String mongoSSLBucket;

    @Value("${" + EnvironmentProperties.MONGO_SSL_FILE + "}")
    private String mongoSSLFile;

    private final S3Template s3Template;

    @Override
    public SSLContext load() {
        try {
            return createSSLConfigurationImpl();
        } catch (IOException | CertificateException | KeyStoreException | NoSuchAlgorithmException |
                 KeyManagementException e) {
            throw new ApplicationException(UNKNOWN_ERROR, e.getMessage());
        }
    }

    private SSLContext createSSLConfigurationImpl() throws IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        var certContent = downloadAsReader(s3Template);

        var allCertificates = Stream.of(certContent.split(END_OF_CERTIFICATE_DELIMITER))
                .filter(line -> !line.isBlank())
                .map(line -> line + END_OF_CERTIFICATE_DELIMITER)
                .collect(toUnmodifiableSet());

        var certificateFactory = CertificateFactory.getInstance(CERTIFICATE_TYPE);
        var keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null);

        var certNumber = 1;
        for (String cert : allCertificates) {
            var caCert = certificateFactory.generateCertificate(new ByteArrayInputStream(cert.getBytes()));
            keyStore.setCertificateEntry(String.format("AWS-certificate-%s", certNumber++), caCert);
        }

        var trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);

        SSLContext sslContext = SSLContext.getInstance(TLS_PROTOCOL);
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);

        return sslContext;
    }

    private String downloadAsReader(S3Template s3Template) {
        var resource = s3Template.download(mongoSSLBucket, mongoSSLFile);

        try {
            return IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ApplicationException(UNKNOWN_ERROR, e.getMessage());
        }
    }
}
