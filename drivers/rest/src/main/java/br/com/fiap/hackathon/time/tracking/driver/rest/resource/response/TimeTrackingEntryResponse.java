package br.com.fiap.hackathon.time.tracking.driver.rest.resource.response;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalTime;

@Data
@Accessors(chain = true)
@Builder
public class TimeTrackingEntryResponse {

    private LocalTime entrance;
    private LocalTime exit;

}
