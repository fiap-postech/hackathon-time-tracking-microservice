package br.com.fiap.hackathon.time.tracking.driver.rest.resource;

import br.com.fiap.hackathon.time.tracking.adapter.controller.ReadTimeTrackingController;
import br.com.fiap.hackathon.time.tracking.driver.rest.mapping.TimeTrackingResponseMapping;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.doc.VisualizeTimeTrackingResourceDoc;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.response.TimeTrackingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/time-tracking")
@RequiredArgsConstructor
public class VisualizeTimeTrackingResource implements VisualizeTimeTrackingResourceDoc {

    private final ReadTimeTrackingController controller;
    private final TimeTrackingResponseMapping mapping;

    @Override
    @GetMapping
    public ResponseEntity<TimeTrackingResponse> get(String employeeId, LocalDate date) {
        return controller.read(employeeId, date)
                .map(mapping::toResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }
}
