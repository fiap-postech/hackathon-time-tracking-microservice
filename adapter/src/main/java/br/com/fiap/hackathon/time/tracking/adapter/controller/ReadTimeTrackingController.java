package br.com.fiap.hackathon.time.tracking.adapter.controller;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;

import java.time.LocalDate;
import java.util.Optional;

public interface ReadTimeTrackingController {

    Optional<TimeTrackingDTO> read(String employeeId, LocalDate date);

}
