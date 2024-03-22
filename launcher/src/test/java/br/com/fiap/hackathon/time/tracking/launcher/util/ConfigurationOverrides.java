package br.com.fiap.hackathon.time.tracking.launcher.util;

import io.restassured.RestAssured;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;

import static br.com.fiap.hackathon.time.tracking.launcher.containers.DatabaseContainers.DATABASE_NAME;
import static org.slf4j.LoggerFactory.getLogger;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigurationOverrides {

    private static final Logger LOGGER = getLogger(ConfigurationOverrides.class);

    private static final int LOCAL_PORT = 8691;

    public static void overrideConfiguration(DynamicPropertyRegistry registry, MongoDBContainer database, GenericContainer<?> localstack) {
        localstack.followOutput(new Slf4jLogConsumer(LOGGER));

        registry.add("spring.data.mongodb.uri", database::getConnectionString);
        registry.add("spring.data.mongodb.database", () -> DATABASE_NAME);

        registry.add("server.port", () -> String.valueOf(LOCAL_PORT));

        RestAssured.port = LOCAL_PORT;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

}