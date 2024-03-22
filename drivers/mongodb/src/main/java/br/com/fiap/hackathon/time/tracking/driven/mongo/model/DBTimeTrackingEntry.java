package br.com.fiap.hackathon.time.tracking.driven.mongo.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class DBTimeTrackingEntry {

    private String uuid;
    private LocalDateTime timestamp;

}
