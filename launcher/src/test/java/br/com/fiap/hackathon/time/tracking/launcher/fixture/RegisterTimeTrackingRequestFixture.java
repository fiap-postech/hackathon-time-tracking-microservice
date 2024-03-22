package br.com.fiap.hackathon.time.tracking.launcher.fixture;

import br.com.fiap.hackathon.time.tracking.driver.rest.resource.request.RegisterTimeTrackingRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegisterTimeTrackingRequestFixture {

    public static Model<RegisterTimeTrackingRequest> registerTimeTrackingRequestModel() {
        return Instancio.of(RegisterTimeTrackingRequest.class)
                .generate(field(RegisterTimeTrackingRequest::getTimestamp), gen -> gen.temporal().localDateTime().past())
                .toModel();
    }

}