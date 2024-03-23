package br.com.fiap.hackathon.time.tracking.adapter.event;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingEntryDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class TimeTrackingEvent {

    private String uuid;
    private String employeeId;
    private LocalDate date;
    private TimeTrackingEntryEvent entry;

}
