package br.com.fiap.hackathon.time.tracking.launcher.configuration;

import br.com.fiap.hackathon.time.tracking.driven.event.producer.TimeTrackingEventProducerConfiguration;
import br.com.fiap.hackathon.time.tracking.driven.mongo.config.MongoConfiguration;
import br.com.fiap.hackathon.time.tracking.driver.rest.config.RestConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RestConfiguration.class,
        ControllerConfiguration.class,
        TimeTrackingEventProducerConfiguration.class,
        UseCaseConfiguration.class,
        MongoConfiguration.class,
        PresenterConfiguration.class,
        GatewayConfiguration.class
})
public class MainConfiguration {
}
