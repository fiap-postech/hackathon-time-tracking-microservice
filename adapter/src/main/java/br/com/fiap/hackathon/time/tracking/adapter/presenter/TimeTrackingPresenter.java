package br.com.fiap.hackathon.time.tracking.adapter.presenter;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;
import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;
import br.com.fiap.hackathon.time.tracking.enterprise.valueobject.TimeTrackingEntry;

public interface TimeTrackingPresenter {

    TimeTrackingDTO present(TimeTracking timeTracking);

}
