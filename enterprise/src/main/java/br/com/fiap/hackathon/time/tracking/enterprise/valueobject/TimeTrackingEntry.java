package br.com.fiap.hackathon.time.tracking.enterprise.valueobject;

import br.com.fiap.tech.challenge.enterprise.valueobject.ValueObject;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

@Getter
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
public class TimeTrackingEntry extends ValueObject {

    @NotNull
    private final UUID uuid;

    @NotNull
    private final LocalDateTime timestamp;

    @Builder(toBuilder = true)
    public TimeTrackingEntry(UUID uuid, LocalDateTime timestamp) {
        this.uuid = defaultIfNull(uuid, UUID.randomUUID());
        this.timestamp = timestamp;

        validate();
    }
}
