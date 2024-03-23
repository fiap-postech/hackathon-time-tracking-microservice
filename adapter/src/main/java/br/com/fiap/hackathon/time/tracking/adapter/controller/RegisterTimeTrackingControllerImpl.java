package br.com.fiap.hackathon.time.tracking.adapter.controller;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.adapter.presenter.TimeTrackingPresenter;
import br.com.fiap.hackathon.time.tracking.application.usecase.RegisterTimeTrackingUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class RegisterTimeTrackingControllerImpl implements RegisterTimeTrackingController {

    private final RegisterTimeTrackingUseCase useCase;
    private final TimeTrackingPresenter presenter;

    @Override
    public TimeTrackingDTO register(String employeeId) {
        return presenter.present(useCase.register(employeeId));
    }
}
