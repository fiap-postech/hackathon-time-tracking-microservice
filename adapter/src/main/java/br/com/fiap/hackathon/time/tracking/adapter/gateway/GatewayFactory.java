package br.com.fiap.hackathon.time.tracking.adapter.gateway;

import br.com.fiap.hackathon.time.tracking.adapter.repository.TimeTrackingReaderRepository;
import br.com.fiap.hackathon.time.tracking.adapter.repository.TimeTrackingWriterRepository;
import br.com.fiap.hackathon.time.tracking.application.gateway.RegisterTimeTrackingGateway;
import br.com.fiap.hackathon.time.tracking.application.gateway.TimeTrackingReaderGateway;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GatewayFactory {

    public static RegisterTimeTrackingGateway registerTimeTrackingGateway(TimeTrackingWriterRepository repository) {
        return new RegisterTImeTrackingGatewayImpl(repository);
    }

    public static TimeTrackingReaderGateway timeTrackingReaderGateway(TimeTrackingReaderRepository repository) {
        return new TimeTrackingReaderGatewayImpl(repository);
    }

}
