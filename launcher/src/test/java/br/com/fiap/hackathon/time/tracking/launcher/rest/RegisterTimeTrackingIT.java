package br.com.fiap.hackathon.time.tracking.launcher.rest;

import br.com.fiap.hackathon.time.tracking.launcher.config.TestConfiguration;
import br.com.fiap.hackathon.time.tracking.launcher.service.ReceiveEventService;
import br.com.fiap.hackathon.time.tracking.launcher.util.ConfigurationOverrides;
import io.restassured.RestAssured;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;

import static br.com.fiap.hackathon.time.tracking.launcher.containers.DatabaseContainers.localMongoDbContainer;
import static br.com.fiap.hackathon.time.tracking.launcher.containers.LocalStackContainers.localStackContainer;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = TestConfiguration.class
)
@ActiveProfiles({"test"})
@Testcontainers
@DirtiesContext(classMode = AFTER_CLASS)
class RegisterTimeTrackingIT {

    @Container
    protected static final MongoDBContainer DATABASE = localMongoDbContainer();

    @MockBean
    private ReceiveEventService receiveEventService;

    @Container
    protected static GenericContainer<?> LOCAL_STACK_CONTAINER = localStackContainer();

    @DynamicPropertySource
    static void overrideConfig(DynamicPropertyRegistry registry) {
        ConfigurationOverrides.overrideConfiguration(registry, DATABASE, LOCAL_STACK_CONTAINER);
    }

    @RepeatedTest(5)
    void registerTimeTrackingTest() {
        RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("x-employee-id", "102030")
                .when()
                .post("/time-tracking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body(matchesJsonSchemaInClasspath("./schemas/RegisterTimeTrackingSchema.json"));

        Awaitility.given().await()
                .pollInterval(Duration.ofSeconds(1))
                .atMost(Duration.ofSeconds(10))
                .ignoreExceptions()
                .until(() -> {
                    try {
                        verify(receiveEventService).receive(any());
                    } catch (AssertionError e) {
                        return false;
                    }

                    return true;
                });
    }
}
