package br.com.fiap.hackathon.time.tracking.application.usecase;

import br.com.fiap.hackathon.time.tracking.application.gateway.TimeTrackingReaderGateway;
import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
class ReadTimeTrackingUseCaseImpl implements ReadTimeTrackingUseCase {

    private final TimeTrackingReaderGateway readerGateway;

    @Override
    public Optional<TimeTracking> read(String employeeId, LocalDate date) {
        return readerGateway.read(employeeId, date);
    }
}
