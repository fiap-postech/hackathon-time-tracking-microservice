package br.com.fiap.hackathon.time.tracking.adapter.mapping;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingEntryDTO;
import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEntryEvent;
import br.com.fiap.hackathon.time.tracking.enterprise.valueobject.TimeTrackingEntry;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { CommonMapper.class })
public interface TimeTrackingEntryMapper {

    TimeTrackingEntryMapper INSTANCE = Mappers.getMapper(TimeTrackingEntryMapper.class);

    @Mapping(target = "uuid", expression = "java(entry.uuid().toString())")
    @Mapping(target = "timestamp", expression = "java(entry.timestamp())")
    TimeTrackingEntryDTO toDTO(TimeTrackingEntry entry);

    @Mapping(target = "uuid", expression = "java(entry.uuid().toString())")
    @Mapping(target = "timestamp", expression = "java(entry.timestamp().toLocalTime())")
    TimeTrackingEntryEvent toEvent(TimeTrackingEntry entry);

    @Mapping(target = "uuid", source = "uuid", qualifiedByName = "buildUUID")
    TimeTrackingEntry toDomain(TimeTrackingEntryDTO dto);

}
