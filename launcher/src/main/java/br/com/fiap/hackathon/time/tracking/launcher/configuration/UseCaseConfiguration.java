package br.com.fiap.hackathon.time.tracking.launcher.configuration;

import br.com.fiap.hackathon.time.tracking.application.gateway.RegisterTimeTrackingGateway;
import br.com.fiap.hackathon.time.tracking.application.gateway.TimeTrackingReaderGateway;
import br.com.fiap.hackathon.time.tracking.application.usecase.ReadTimeTrackingUseCase;
import br.com.fiap.hackathon.time.tracking.application.usecase.RegisterTimeTrackingUseCase;
import br.com.fiap.hackathon.time.tracking.application.usecase.UseCaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public RegisterTimeTrackingUseCase registerTimeTrackingUseCase(RegisterTimeTrackingGateway registerGateway, TimeTrackingReaderGateway readerGateway) {
        return UseCaseFactory.registerTimeTrackingUseCase(registerGateway, readerGateway);
    }

    @Bean
    public ReadTimeTrackingUseCase readTimeTrackingUseCase(TimeTrackingReaderGateway readerGateway) {
        return UseCaseFactory.readTimeTrackingUseCase(readerGateway);
    }
}
