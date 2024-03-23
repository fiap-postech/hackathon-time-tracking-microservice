package br.com.fiap.hackathon.time.tracking.application.usecase;

import br.com.fiap.hackathon.time.tracking.application.gateway.PublishTimeTrackingGateway;
import br.com.fiap.hackathon.time.tracking.application.gateway.RegisterTimeTrackingGateway;
import br.com.fiap.hackathon.time.tracking.application.gateway.TimeTrackingReaderGateway;
import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;
import br.com.fiap.hackathon.time.tracking.enterprise.valueobject.TimeTrackingEntry;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
class RegisterTimeTrackingUseCaseImpl implements RegisterTimeTrackingUseCase {

    private final RegisterTimeTrackingGateway registerGateway;
    private final TimeTrackingReaderGateway readerGateway;
    private final PublishTimeTrackingGateway publishGateway;

    @Override
    public TimeTracking register(String employeeId) {
        var now = LocalDateTime.now();

        var timeTracking = readerGateway.read(employeeId, now.toLocalDate())
                .orElseGet(() -> create(employeeId, now.toLocalDate()));

        var entry = TimeTrackingEntry.builder()
                .timestamp(now)
                .build();

        var stored = registerGateway.register(timeTracking.addEntry(entry));

        publishGateway.publish(stored, entry);

        return stored;
    }

    private TimeTracking create(String employeeId, LocalDate date) {
        return TimeTracking.builder()
                .date(date)
                .employeeId(employeeId)
                .build();
    }
}
