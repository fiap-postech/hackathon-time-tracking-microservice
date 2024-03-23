package br.com.fiap.hackathon.time.tracking.driver.rest.resource;

import br.com.fiap.hackathon.time.tracking.adapter.controller.RegisterTimeTrackingController;
import br.com.fiap.hackathon.time.tracking.driver.rest.mapping.RegisterTimeTrackingResponseMapping;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.doc.RegisterTimeTrackingResourceDoc;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.response.RegisterTimeTrackingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/time-tracking")
@RequiredArgsConstructor
public class RegisterTimeTrackingResource implements RegisterTimeTrackingResourceDoc {

    private final RegisterTimeTrackingController registerController;
    private final RegisterTimeTrackingResponseMapping mapping;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public RegisterTimeTrackingResponse register(String employeeId) {
        return mapping.toResponse(registerController.register(employeeId));
    }
}