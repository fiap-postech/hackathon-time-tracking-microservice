package br.com.fiap.hackathon.time.tracking.adapter.controller;

import br.com.fiap.hackathon.time.tracking.adapter.presenter.TimeTrackingPresenter;
import br.com.fiap.hackathon.time.tracking.application.usecase.ReadTimeTrackingUseCase;
import br.com.fiap.hackathon.time.tracking.application.usecase.RegisterTimeTrackingUseCase;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ControllerFactory {

    public static ReadTimeTrackingController readTimeTrackingController(ReadTimeTrackingUseCase useCase, TimeTrackingPresenter presenter) {
        return new ReadTimeTrackingControllerImpl(useCase, presenter);
    }

    public static RegisterTimeTrackingController registerTimeTrackingUseCase(RegisterTimeTrackingUseCase useCase, TimeTrackingPresenter presenter) {
        return new RegisterTimeTrackingControllerImpl(useCase, presenter);
    }

}
