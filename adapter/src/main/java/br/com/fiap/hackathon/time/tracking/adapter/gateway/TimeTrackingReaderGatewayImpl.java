package br.com.fiap.hackathon.time.tracking.adapter.gateway;

import br.com.fiap.hackathon.time.tracking.adapter.mapping.TImeTrackingMapper;
import br.com.fiap.hackathon.time.tracking.adapter.repository.TimeTrackingReaderRepository;
import br.com.fiap.hackathon.time.tracking.application.gateway.TimeTrackingReaderGateway;
import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
class TimeTrackingReaderGatewayImpl implements TimeTrackingReaderGateway {

    private final TimeTrackingReaderRepository repository;

    @Override
    public Optional<TimeTracking> read(String employeeId, LocalDate date) {
        return repository.read(employeeId, date)
                .map(TImeTrackingMapper.INSTANCE::toDomain);
    }
}
