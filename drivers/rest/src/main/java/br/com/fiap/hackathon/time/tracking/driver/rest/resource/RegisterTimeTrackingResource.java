package br.com.fiap.hackathon.time.tracking.driver.rest.resource;

import br.com.fiap.hackathon.time.tracking.adapter.controller.RegisterTimeTrackingController;
import br.com.fiap.hackathon.time.tracking.adapter.dto.RegisterTimeEntryDTO;
import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.doc.RegisterTimeTrackingResourceDoc;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.request.RegisterTimeTrackingRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/time-tracking")
@RequiredArgsConstructor
public class RegisterTimeTrackingResource implements RegisterTimeTrackingResourceDoc {

    private final RegisterTimeTrackingController registerController;

    @Override
    @PostMapping
    @ResponseStatus(CREATED)
    public TimeTrackingEvent register(String employeeId, RegisterTimeTrackingRequest request) {
        var dto = new RegisterTimeEntryDTO()
                .setEmployeeId(employeeId)
                .setTimestamp(request.getTimestamp());

        return registerController.register(dto);
    }
}