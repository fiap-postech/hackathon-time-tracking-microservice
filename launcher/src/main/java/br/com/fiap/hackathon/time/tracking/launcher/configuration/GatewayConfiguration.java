package br.com.fiap.hackathon.time.tracking.launcher.configuration;

import br.com.fiap.hackathon.time.tracking.adapter.gateway.GatewayFactory;
import br.com.fiap.hackathon.time.tracking.adapter.repository.TimeTrackingReaderRepository;
import br.com.fiap.hackathon.time.tracking.adapter.repository.TimeTrackingWriterRepository;
import br.com.fiap.hackathon.time.tracking.application.gateway.RegisterTimeTrackingGateway;
import br.com.fiap.hackathon.time.tracking.application.gateway.TimeTrackingReaderGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RegisterTimeTrackingGateway registerTimeTrackingGateway(TimeTrackingWriterRepository repository) {
        return GatewayFactory.registerTimeTrackingGateway(repository);
    }

    @Bean
    public TimeTrackingReaderGateway timeTrackingReaderGateway(TimeTrackingReaderRepository repository) {
        return GatewayFactory.timeTrackingReaderGateway(repository);
    }
}
