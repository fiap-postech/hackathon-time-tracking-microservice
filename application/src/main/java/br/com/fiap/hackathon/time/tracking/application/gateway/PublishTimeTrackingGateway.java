package br.com.fiap.hackathon.time.tracking.application.gateway;

import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;
import br.com.fiap.hackathon.time.tracking.enterprise.valueobject.TimeTrackingEntry;

public interface PublishTimeTrackingGateway {

    void publish(TimeTracking timeTracking, TimeTrackingEntry entry);
}
