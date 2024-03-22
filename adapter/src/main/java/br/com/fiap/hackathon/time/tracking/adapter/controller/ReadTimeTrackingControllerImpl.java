package br.com.fiap.hackathon.time.tracking.adapter.controller;

import br.com.fiap.hackathon.time.tracking.adapter.presenter.TimeTrackingPresenter;
import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.application.usecase.ReadTimeTrackingUseCase;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
class ReadTimeTrackingControllerImpl implements ReadTimeTrackingController {

    private final ReadTimeTrackingUseCase useCase;
    private final TimeTrackingPresenter presenter;

    @Override
    public Optional<TimeTrackingDTO> read(String employeeId, LocalDate date) {
        return useCase.read(employeeId, date)
                .map(presenter::present);
    }
}
