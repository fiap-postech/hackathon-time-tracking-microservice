package br.com.fiap.hackathon.time.tracking.adapter.repository;

import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;

public interface TimeTrackingEventRepository {

    void publish(TimeTrackingEvent event);

}
