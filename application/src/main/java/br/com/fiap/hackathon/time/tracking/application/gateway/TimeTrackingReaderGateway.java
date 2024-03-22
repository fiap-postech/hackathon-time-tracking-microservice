package br.com.fiap.hackathon.time.tracking.application.gateway;

import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;

import java.time.LocalDate;
import java.util.Optional;

public interface TimeTrackingReaderGateway {

    Optional<TimeTracking> read(String employeeId, LocalDate date);

}
