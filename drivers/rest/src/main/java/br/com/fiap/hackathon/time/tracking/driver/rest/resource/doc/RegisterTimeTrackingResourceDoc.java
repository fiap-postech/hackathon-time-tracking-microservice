package br.com.fiap.hackathon.time.tracking.driver.rest.resource.doc;

import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.request.RegisterTimeTrackingRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "Registro de Ponto", description = "API responsável pelo registro de ponto do funcionário")
public interface RegisterTimeTrackingResourceDoc {

    @Operation(
            summary = "Realiza o registro do ponto",
            description = "Endpoint para registro de pontos dos funcionários.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "OK - Retorna a visão do registro realizado.", useReturnTypeSchema = true)
            }
    )
    TimeTrackingEvent register(@RequestHeader(name = "x-employee-id") String employeeId, @RequestBody @Valid RegisterTimeTrackingRequest request);
}
