package br.com.fiap.hackathon.time.tracking.driven.mongo.mapping;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.driven.mongo.model.TimeTrackingEntity;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface DBTimeTrackingMapper {

    TimeTrackingDTO toDTO(TimeTrackingEntity entity);

    TimeTrackingEntity toEntity(TimeTrackingDTO dto);

}
