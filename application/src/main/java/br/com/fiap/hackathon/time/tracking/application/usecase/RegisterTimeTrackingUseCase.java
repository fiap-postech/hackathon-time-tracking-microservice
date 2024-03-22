package br.com.fiap.hackathon.time.tracking.application.usecase;

import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;
import br.com.fiap.hackathon.time.tracking.enterprise.valueobject.TimeTrackingEntry;

import java.time.LocalDate;

public interface RegisterTimeTrackingUseCase {

    TimeTracking register(String employeeId, LocalDate date, TimeTrackingEntry entry);

}
