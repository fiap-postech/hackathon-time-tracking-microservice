package br.com.fiap.hackathon.time.tracking.driver.rest.resource.doc;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.request.RegisterTimeTrackingRequest;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.response.TimeTrackingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Tag(name = "Registro de Ponto", description = "API responsável pelo registro de ponto do funcionário")
public interface VisualizeTimeTrackingResourceDoc {

    @Operation(
            summary = "Consulta o lançamento de ponto por data",
            description = "Endpoint para consulta de lançamento de ponto por dia",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK - Retorna a visão do registro realizado.", useReturnTypeSchema = true)
            }
    )
    ResponseEntity<TimeTrackingResponse> get(@RequestHeader(name = "x-employee-id") String employeeId, @RequestParam("date") LocalDate date);
}
