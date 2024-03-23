package br.com.fiap.hackathon.time.tracking.driver.rest.resource.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalTime;

@Data
@Accessors(chain = true)
@Builder
public class VisualizeTimeTrackingEntryResponse {

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime entrance;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime exit;

}
