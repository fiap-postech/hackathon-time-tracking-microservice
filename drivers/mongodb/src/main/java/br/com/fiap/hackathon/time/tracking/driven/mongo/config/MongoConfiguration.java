package br.com.fiap.hackathon.time.tracking.driven.mongo.config;

import io.awspring.cloud.s3.S3Template;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("br.com.fiap.hackathon.time.tracking.driven.mongo")
public class MongoConfiguration {

    @Bean
    @Profile({"dev", "hml", "prod"})
    public SSLLoader loader(S3Template s3Template) {
        return new SSLLoaderImpl(s3Template);
    }

}
