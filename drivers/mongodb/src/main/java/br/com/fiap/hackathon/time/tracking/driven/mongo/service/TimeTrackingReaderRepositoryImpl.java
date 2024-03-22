package br.com.fiap.hackathon.time.tracking.driven.mongo.service;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.adapter.repository.TimeTrackingReaderRepository;
import br.com.fiap.hackathon.time.tracking.driven.mongo.mapping.DBTimeTrackingMapper;
import br.com.fiap.hackathon.time.tracking.driven.mongo.repository.TimeTrackingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeTrackingReaderRepositoryImpl implements TimeTrackingReaderRepository {

    private final TimeTrackingRepository repository;
    private final DBTimeTrackingMapper mapper;

    @Override
    public Optional<TimeTrackingDTO> read(String employeeId, LocalDate date) {
        return repository.findByEmployeeIdAndDate(employeeId, date)
                .map(mapper::toDTO);
    }
}
