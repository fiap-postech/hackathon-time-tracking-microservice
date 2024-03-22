package br.com.fiap.hackathon.time.tracking.adapter.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class TimeTrackingEntryDTO {

    private String uuid;
    private LocalDateTime timestamp;

}
