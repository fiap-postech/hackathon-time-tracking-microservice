package br.com.fiap.hackathon.time.tracking.driven.mongo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import static org.slf4j.LoggerFactory.getLogger;

@Profile({"dev", "hml", "prod"})
@Configuration
public class DocumentDBConfiguration extends AbstractMongoClientConfiguration {

    private static final Logger LOGGER = getLogger(DocumentDBConfiguration.class);

    private static final String CONNECTION_STRING_TEMPLATE = "mongodb://%s:%s@%s:%s/%s?directConnection=true&serverSelectionTimeoutMS=2000&tlsAllowInvalidHostnames=true&tls=true&retryWrites=false";

    @Value("${" + EnvironmentProperties.DATABASE_NAME + "}")
    private String databaseName;

    @Value("${" + EnvironmentProperties.DATABASE_HOST + "}")
    private String databaseHost;

    @Value("${" + EnvironmentProperties.DATABASE_PORT + "}")
    private String databasePort;

    @Value("${" + EnvironmentProperties.DATABASE_USERNAME + "}")
    private String databaseUsername;

    @Value("${" + EnvironmentProperties.DATABASE_PASSWORD + "}")
    private String databasePassword;

    @SuppressWarnings("java:S6813")
    @Autowired
    private SSLLoader sslLoader;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        LOGGER.info("DocumentDBConfiguration.configureClientSettings start");

        super.configureClientSettings(builder);

        builder.applyConnectionString(new ConnectionString(getConnectionString()));
        builder.applyToSslSettings(ssl -> ssl.enabled(true).context(sslLoader.load()));
    }

    private String getConnectionString() {
        return String.format(
                CONNECTION_STRING_TEMPLATE,
                databaseUsername,
                databasePassword,
                databaseHost,
                databasePort,
                getDatabaseName()
        );
    }
}
