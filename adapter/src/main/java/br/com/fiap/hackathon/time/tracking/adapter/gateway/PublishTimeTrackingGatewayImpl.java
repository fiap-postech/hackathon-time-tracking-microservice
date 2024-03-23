package br.com.fiap.hackathon.time.tracking.adapter.gateway;

import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;
import br.com.fiap.hackathon.time.tracking.adapter.mapping.TimeTrackingEntryMapper;
import br.com.fiap.hackathon.time.tracking.adapter.repository.TimeTrackingEventRepository;
import br.com.fiap.hackathon.time.tracking.application.gateway.PublishTimeTrackingGateway;
import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;
import br.com.fiap.hackathon.time.tracking.enterprise.valueobject.TimeTrackingEntry;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class PublishTimeTrackingGatewayImpl implements PublishTimeTrackingGateway {

    private final TimeTrackingEventRepository repository;

    @Override
    public void publish(TimeTracking timeTracking, TimeTrackingEntry entry) {
        repository.publish(toEvent(timeTracking, entry));
    }

    public TimeTrackingEvent toEvent(TimeTracking timeTracking, TimeTrackingEntry entry) {
        return new TimeTrackingEvent()
                .setUuid(timeTracking.uuid().toString())
                .setDate(timeTracking.date())
                .setEmployeeId(timeTracking.employeeId())
                .setEntry(TimeTrackingEntryMapper.INSTANCE.toEvent(entry));
    }
}
