package br.com.fiap.hackathon.time.tracking.adapter.repository;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;

import java.time.LocalDate;
import java.util.Optional;

public interface TimeTrackingReaderRepository {

    Optional<TimeTrackingDTO> read(String employeeId, LocalDate date);

}
