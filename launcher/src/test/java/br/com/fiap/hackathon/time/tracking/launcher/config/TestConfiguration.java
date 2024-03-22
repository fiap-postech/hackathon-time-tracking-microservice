package br.com.fiap.hackathon.time.tracking.launcher.config;

import br.com.fiap.hackathon.time.tracking.driven.event.producer.TimeTrackingEventProducerConfiguration;
import br.com.fiap.hackathon.time.tracking.driven.mongo.config.MongoConfiguration;
import br.com.fiap.hackathon.time.tracking.driver.rest.config.RestConfiguration;
import br.com.fiap.hackathon.time.tracking.launcher.configuration.ControllerConfiguration;
import br.com.fiap.hackathon.time.tracking.launcher.configuration.GatewayConfiguration;
import br.com.fiap.hackathon.time.tracking.launcher.configuration.PresenterConfiguration;
import br.com.fiap.hackathon.time.tracking.launcher.configuration.UseCaseConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "br.com.fiap.hackathon.time.tracking")
@EntityScan(basePackages = "br.com.fiap.hackathon.time.tracking")
@Import(
        {
                RestConfiguration.class,
                ControllerConfiguration.class,
                TimeTrackingEventProducerConfiguration.class,
                UseCaseConfiguration.class,
                MongoConfiguration.class,
                PresenterConfiguration.class,
                GatewayConfiguration.class
        }
)
public class TestConfiguration {
}
