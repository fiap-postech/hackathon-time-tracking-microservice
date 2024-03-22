package br.com.fiap.hackathon.time.tracking.adapter.mapping;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingEntryDTO;
import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = { CommonMapper.class, TimeTrackingEntryMapper.class })
public interface TImeTrackingMapper {

    TImeTrackingMapper INSTANCE = Mappers.getMapper(TImeTrackingMapper.class);

    @Mapping(target = "uuid", expression = "java(timeTracking.uuid().toString())")
    @Mapping(target = "employeeId", expression = "java(timeTracking.employeeId())")
    @Mapping(target = "date", expression = "java(timeTracking.date())")
    @Mapping(target = "entries", source = "timeTracking", qualifiedByName = "entriesToDTO")
    TimeTrackingDTO toDTO(TimeTracking timeTracking);

    @Mapping(target = "uuid", source = "uuid", qualifiedByName = "buildUUID")
    TimeTracking toDomain(TimeTrackingDTO dto);

    @Named("entriesToDTO")
    static List<TimeTrackingEntryDTO> buildEntriesToDTO(TimeTracking tracking) {
        return tracking.entries().stream().map(TimeTrackingEntryMapper.INSTANCE::toDTO).toList();
    }

}
