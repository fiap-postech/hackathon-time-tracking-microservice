package br.com.fiap.hackathon.time.tracking.launcher.configuration;

import br.com.fiap.hackathon.time.tracking.adapter.controller.ControllerFactory;
import br.com.fiap.hackathon.time.tracking.adapter.controller.ReadTimeTrackingController;
import br.com.fiap.hackathon.time.tracking.adapter.controller.RegisterTimeTrackingController;
import br.com.fiap.hackathon.time.tracking.adapter.presenter.TimeTrackingPresenter;
import br.com.fiap.hackathon.time.tracking.application.usecase.ReadTimeTrackingUseCase;
import br.com.fiap.hackathon.time.tracking.application.usecase.RegisterTimeTrackingUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfiguration {

    @Bean
    public RegisterTimeTrackingController registerTimeTrackingController(RegisterTimeTrackingUseCase useCase, TimeTrackingPresenter presenter) {
        return ControllerFactory.registerTimeTrackingUseCase(useCase, presenter);
    }

    @Bean
    public ReadTimeTrackingController readTimeTrackingController(ReadTimeTrackingUseCase useCase, TimeTrackingPresenter presenter) {
        return ControllerFactory.readTimeTrackingController(useCase, presenter);
    }
}
