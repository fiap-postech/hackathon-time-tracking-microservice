package br.com.fiap.hackathon.time.tracking.driven.mongo.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnvironmentProperties {

    public static final String MONGO_SSL_BUCKET = "time-tracking-service.configuration.s3.mongo-ssl.bucket";

    public static final String MONGO_SSL_FILE = "time-tracking-service.configuration.s3.mongo-ssl.file";

    public static final String DATABASE_NAME = "db.database";

    public static final String DATABASE_HOST = "db.host";

    public static final String DATABASE_PORT = "db.port";

    public static final String DATABASE_USERNAME = "db.username";

    public static final String DATABASE_PASSWORD = "db.password";

}
