package br.com.fiap.hackathon.time.tracking.driver.rest.mapping;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingEntryDTO;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.response.VisualizeTimeTrackingEntryResponse;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.response.VisualizeTimeTrackingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.lang.Math.min;
import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface VisualizeTimeTrackingResponseMapping {

    int BATCH_SIZE = 2;

    @Mapping(target = "id", source = "uuid")
    @Mapping(target = "entries", source = "entries", qualifiedByName = "toEntryResponse")
    VisualizeTimeTrackingResponse toResponse(TimeTrackingDTO dto);

    @Named("toEntryResponse")
    static List<VisualizeTimeTrackingEntryResponse> toEntryResponse(List<TimeTrackingEntryDTO> entries) {
        var items = new ArrayList<>(entries);

        items.sort(Comparator.comparing(TimeTrackingEntryDTO::getTimestamp));

        int batches = (int) Math.ceil((double) items.size() / BATCH_SIZE);

        return IntStream.range(0, batches)
                .mapToObj(batch -> {
                    int startIndex = batch * BATCH_SIZE;
                    int endIndex = min(entries.size() , startIndex + BATCH_SIZE);
                    return items.subList(startIndex, endIndex);
                })
                .map(VisualizeTimeTrackingResponseMapping::buildEntry)
                .toList();
    }

    static VisualizeTimeTrackingEntryResponse buildEntry(List<TimeTrackingEntryDTO> items) {
        var entrance = items.get(0).getTimestamp().toLocalTime();

        var exit = items.size() == BATCH_SIZE ?  Optional.of(items.get(1))
                .map(TimeTrackingEntryDTO::getTimestamp)
                .map(LocalDateTime::toLocalTime)
                .orElse(null) : null;

        return VisualizeTimeTrackingEntryResponse.builder()
                .entrance(entrance)
                .exit(exit)
                .build();
    }
}
