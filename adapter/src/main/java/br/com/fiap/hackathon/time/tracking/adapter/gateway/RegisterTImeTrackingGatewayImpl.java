package br.com.fiap.hackathon.time.tracking.adapter.gateway;

import br.com.fiap.hackathon.time.tracking.adapter.mapping.TImeTrackingMapper;
import br.com.fiap.hackathon.time.tracking.adapter.repository.TimeTrackingWriterRepository;
import br.com.fiap.hackathon.time.tracking.application.gateway.RegisterTimeTrackingGateway;
import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class RegisterTImeTrackingGatewayImpl implements RegisterTimeTrackingGateway {

    private final TimeTrackingWriterRepository repository;

    @Override
    public TimeTracking register(TimeTracking timeTracking) {
        var mapper = TImeTrackingMapper.INSTANCE;

        return mapper.toDomain(repository.write(mapper.toDTO(timeTracking)));
    }
}
