package br.com.fiap.hackathon.time.tracking.launcher.rest;

import br.com.fiap.hackathon.time.tracking.driven.mongo.repository.TimeTrackingRepository;
import br.com.fiap.hackathon.time.tracking.launcher.config.TestConfiguration;
import br.com.fiap.hackathon.time.tracking.launcher.util.ConfigurationOverrides;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static br.com.fiap.hackathon.time.tracking.launcher.containers.DatabaseContainers.localMongoDbContainer;
import static br.com.fiap.hackathon.time.tracking.launcher.containers.LocalStackContainers.localStackContainer;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = TestConfiguration.class
)
@ActiveProfiles({ "test" })
@Testcontainers
@DirtiesContext(classMode = AFTER_CLASS)
public class RegisterTimeTrackingIT {

    @Container
    protected static final MongoDBContainer DATABASE = localMongoDbContainer();

    @Container
    protected static GenericContainer<?> LOCAL_STACK_CONTAINER = localStackContainer();

    @Autowired
    private TimeTrackingRepository repository;


    @DynamicPropertySource
    static void overrideConfig(DynamicPropertyRegistry registry) {
        ConfigurationOverrides.overrideConfiguration(registry, DATABASE, LOCAL_STACK_CONTAINER);
    }

}
