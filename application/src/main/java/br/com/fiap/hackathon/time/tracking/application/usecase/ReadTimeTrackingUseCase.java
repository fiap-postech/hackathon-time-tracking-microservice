package br.com.fiap.hackathon.time.tracking.application.usecase;

import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;

import java.time.LocalDate;
import java.util.Optional;

public interface ReadTimeTrackingUseCase {

    Optional<TimeTracking> read(String employeeId, LocalDate date);

}
