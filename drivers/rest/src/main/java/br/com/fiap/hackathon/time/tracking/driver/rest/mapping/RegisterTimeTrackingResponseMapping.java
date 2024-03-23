package br.com.fiap.hackathon.time.tracking.driver.rest.mapping;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.driver.rest.resource.response.RegisterTimeTrackingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface RegisterTimeTrackingResponseMapping {

    int BATCH_SIZE = 2;

    @Mapping(target = "id", source = "uuid")
    RegisterTimeTrackingResponse toResponse(TimeTrackingDTO dto);

}
