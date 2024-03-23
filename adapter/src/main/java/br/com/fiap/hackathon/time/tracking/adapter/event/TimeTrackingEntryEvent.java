package br.com.fiap.hackathon.time.tracking.adapter.event;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalTime;

@Data
@Accessors(chain = true)
public class TimeTrackingEntryEvent {

    private String uuid;
    private LocalTime timestamp;

}
