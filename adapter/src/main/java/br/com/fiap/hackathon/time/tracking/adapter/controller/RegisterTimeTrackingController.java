package br.com.fiap.hackathon.time.tracking.adapter.controller;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;

public interface RegisterTimeTrackingController {

    TimeTrackingDTO register(String employeeId);

}
