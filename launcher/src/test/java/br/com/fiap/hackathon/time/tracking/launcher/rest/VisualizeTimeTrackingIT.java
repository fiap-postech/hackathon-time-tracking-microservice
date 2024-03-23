package br.com.fiap.hackathon.time.tracking.launcher.rest;

import br.com.fiap.hackathon.time.tracking.driven.mongo.repository.TimeTrackingRepository;
import br.com.fiap.hackathon.time.tracking.launcher.config.TestConfiguration;
import br.com.fiap.hackathon.time.tracking.launcher.fixture.Fixture;
import br.com.fiap.hackathon.time.tracking.launcher.util.ConfigurationOverrides;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

import java.time.LocalDate;

import static br.com.fiap.hackathon.time.tracking.launcher.containers.DatabaseContainers.localMongoDbContainer;
import static br.com.fiap.hackathon.time.tracking.launcher.containers.LocalStackContainers.localStackContainer;
import static br.com.fiap.hackathon.time.tracking.launcher.fixture.TimeTrackingEntityFixture.timeTrackingEntityModel;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.emptyString;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_CLASS;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = TestConfiguration.class
)
@ActiveProfiles({"test"})
@Testcontainers
@DirtiesContext(classMode = AFTER_CLASS)
class VisualizeTimeTrackingIT {

    @Container
    protected static final MongoDBContainer DATABASE = localMongoDbContainer();

    @Autowired
    private TimeTrackingRepository mongoRepository;

    @Container
    protected static GenericContainer<?> LOCAL_STACK_CONTAINER = localStackContainer();

    @DynamicPropertySource
    static void overrideConfig(DynamicPropertyRegistry registry) {
        ConfigurationOverrides.overrideConfiguration(registry, DATABASE, LOCAL_STACK_CONTAINER);
    }


    @Test
    void registerTimeTrackingTest() {
        mongoRepository.save(Fixture.create(timeTrackingEntityModel()));

        RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("x-employee-id", "102031")
                .param("date", LocalDate.now().toString())
                .when()
                .get("/time-tracking")
                .then()
                .statusCode(HttpStatus.OK.value())
                .body(matchesJsonSchemaInClasspath("./schemas/VisualizeTimeTrackingSchema.json"));
    }

    @Test
    void shouldReturnEmptyWhenNoDataFound() {
        RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("x-employee-id", "102032")
                .param("date", LocalDate.now().toString())
                .when()
                .get("/time-tracking")
                .then()
                .statusCode(HttpStatus.NO_CONTENT.value())
                .body(emptyString());
    }
}
