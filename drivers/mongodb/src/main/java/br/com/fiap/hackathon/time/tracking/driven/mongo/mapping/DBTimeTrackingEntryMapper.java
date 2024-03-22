package br.com.fiap.hackathon.time.tracking.driven.mongo.mapping;


import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingEntryDTO;
import br.com.fiap.hackathon.time.tracking.driven.mongo.model.DBTimeTrackingEntry;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface DBTimeTrackingEntryMapper {

    TimeTrackingEntryDTO toDTO(DBTimeTrackingEntry entry);

    DBTimeTrackingEntry toEntity(TimeTrackingEntryDTO dto);

}
