package br.com.fiap.hackathon.time.tracking.application.usecase;

import br.com.fiap.hackathon.time.tracking.application.gateway.RegisterTimeTrackingGateway;
import br.com.fiap.hackathon.time.tracking.application.gateway.TimeTrackingReaderGateway;
import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;
import br.com.fiap.hackathon.time.tracking.enterprise.valueobject.TimeTrackingEntry;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
class RegisterTimeTrackingUseCaseImpl implements RegisterTimeTrackingUseCase {

    private final RegisterTimeTrackingGateway registerGateway;
    private final TimeTrackingReaderGateway readerGateway;

    @Override
    public TimeTracking register(String employeeId, LocalDate date, TimeTrackingEntry entry) {
        var timeTracking = readerGateway.read(employeeId, date)
                .orElseGet(() -> create(employeeId, date));

        return registerGateway.register(timeTracking.addEntry(entry));
    }

    private TimeTracking create(String employeeId, LocalDate date) {
        return TimeTracking.builder()
                .date(date)
                .employeeId(employeeId)
                .build();
    }
}
