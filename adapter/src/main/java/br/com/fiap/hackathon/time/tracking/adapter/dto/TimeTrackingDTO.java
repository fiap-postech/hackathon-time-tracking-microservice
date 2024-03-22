package br.com.fiap.hackathon.time.tracking.adapter.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Data
@Accessors(chain = true)
public class TimeTrackingDTO {

    private String uuid;
    private String employeeId;
    private LocalDate date;
    private List<TimeTrackingEntryDTO> entries;

}
