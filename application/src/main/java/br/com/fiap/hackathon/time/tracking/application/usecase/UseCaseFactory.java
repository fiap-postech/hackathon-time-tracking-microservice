package br.com.fiap.hackathon.time.tracking.application.usecase;

import br.com.fiap.hackathon.time.tracking.application.gateway.PublishTimeTrackingGateway;
import br.com.fiap.hackathon.time.tracking.application.gateway.RegisterTimeTrackingGateway;
import br.com.fiap.hackathon.time.tracking.application.gateway.TimeTrackingReaderGateway;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UseCaseFactory {

    public static RegisterTimeTrackingUseCase registerTimeTrackingUseCase(RegisterTimeTrackingGateway registerGateway, TimeTrackingReaderGateway readerGateway, PublishTimeTrackingGateway publishGateway) {
        return new RegisterTimeTrackingUseCaseImpl(registerGateway, readerGateway, publishGateway);
    }

    public static ReadTimeTrackingUseCase readTimeTrackingUseCase(TimeTrackingReaderGateway readerGateway) {
        return new ReadTimeTrackingUseCaseImpl(readerGateway);
    }

}
