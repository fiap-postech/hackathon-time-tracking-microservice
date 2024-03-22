package br.com.fiap.hackathon.time.tracking.application.gateway;

import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;

public interface RegisterTimeTrackingGateway {

    TimeTracking register(TimeTracking timeTracking);

}
