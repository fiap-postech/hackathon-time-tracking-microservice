package br.com.fiap.hackathon.time.tracking.driven.mongo.service;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.adapter.repository.TimeTrackingWriterRepository;
import br.com.fiap.hackathon.time.tracking.driven.mongo.mapping.DBTimeTrackingMapper;
import br.com.fiap.hackathon.time.tracking.driven.mongo.repository.TimeTrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeTrackingWriterRepositoryImpl implements TimeTrackingWriterRepository {

    private final TimeTrackingRepository repository;
    private final DBTimeTrackingMapper mapper;

    @Override
    public TimeTrackingDTO write(TimeTrackingDTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }
}
