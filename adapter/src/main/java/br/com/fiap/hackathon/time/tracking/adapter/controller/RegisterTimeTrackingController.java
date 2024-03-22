package br.com.fiap.hackathon.time.tracking.adapter.controller;

import br.com.fiap.hackathon.time.tracking.adapter.dto.RegisterTimeEntryDTO;
import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;

public interface RegisterTimeTrackingController {

    TimeTrackingEvent register(RegisterTimeEntryDTO dto);

}
