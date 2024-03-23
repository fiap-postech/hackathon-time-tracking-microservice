package br.com.fiap.hackathon.time.tracking.driver.rest.resource.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Data
@Accessors(chain = true)
public class VisualizeTimeTrackingResponse {

    private String id;
    private String employeeId;
    private LocalDate date;
    private List<VisualizeTimeTrackingEntryResponse> entries;

}
