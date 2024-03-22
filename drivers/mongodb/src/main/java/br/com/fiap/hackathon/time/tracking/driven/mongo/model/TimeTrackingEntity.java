package br.com.fiap.hackathon.time.tracking.driven.mongo.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "time-tracking")
@Data
@Accessors(chain = true)
public class TimeTrackingEntity {

    @Id
    private String uuid;
    private String employeeId;
    private LocalDate date;
    private List<DBTimeTrackingEntry> entries;

}
