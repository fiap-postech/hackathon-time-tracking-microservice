package br.com.fiap.hackathon.time.tracking.enterprise.entity;

import br.com.fiap.hackathon.time.tracking.enterprise.valueobject.TimeTrackingEntry;
import br.com.fiap.tech.challenge.enterprise.entity.Entity;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

@Getter
@Accessors(fluent = true)
public class TimeTracking extends Entity {

    @NotBlank
    private final String employeeId;

    @NotNull
    private final LocalDate date;

    @Valid
    @NotNull
    private final List<TimeTrackingEntry> entries;

    @Builder(toBuilder = true)
    public TimeTracking(@Builder.ObtainVia(method = "uuid") UUID uuid, String employeeId, LocalDate date, List<TimeTrackingEntry> entries) {
        super(uuid);

        this.employeeId = employeeId;
        this.date = date;
        this.entries = defaultIfNull(entries, new ArrayList<>());

        validate();
    }

    public TimeTracking addEntry(TimeTrackingEntry entry) {
        var items = entries();
        items.add(entry);

        return toBuilder()
                .entries(items)
                .build();
    }
}
