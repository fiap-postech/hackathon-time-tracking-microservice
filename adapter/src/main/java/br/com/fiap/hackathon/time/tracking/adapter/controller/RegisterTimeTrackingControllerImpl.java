package br.com.fiap.hackathon.time.tracking.adapter.controller;

import br.com.fiap.hackathon.time.tracking.adapter.dto.RegisterTimeEntryDTO;
import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;
import br.com.fiap.hackathon.time.tracking.adapter.presenter.TimeTrackingPresenter;
import br.com.fiap.hackathon.time.tracking.application.usecase.RegisterTimeTrackingUseCase;
import br.com.fiap.hackathon.time.tracking.enterprise.valueobject.TimeTrackingEntry;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class RegisterTimeTrackingControllerImpl implements RegisterTimeTrackingController {

    private final RegisterTimeTrackingUseCase useCase;
    private final TimeTrackingPresenter presenter;

    @Override
    public TimeTrackingEvent register(RegisterTimeEntryDTO dto) {
        var entry = TimeTrackingEntry.builder()
                .timestamp(dto.getTimestamp())
                .build();

        var timeTracking = useCase.register(
                dto.getEmployeeId(),
                dto.getTimestamp().toLocalDate(),
                entry
        );

        return presenter.presentEvent(timeTracking, entry);
    }
}
