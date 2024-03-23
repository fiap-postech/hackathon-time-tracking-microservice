package br.com.fiap.hackathon.time.tracking.adapter.presenter;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;
import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;
import br.com.fiap.hackathon.time.tracking.adapter.mapping.TImeTrackingMapper;
import br.com.fiap.hackathon.time.tracking.adapter.mapping.TimeTrackingEntryMapper;
import br.com.fiap.hackathon.time.tracking.enterprise.entity.TimeTracking;
import br.com.fiap.hackathon.time.tracking.enterprise.valueobject.TimeTrackingEntry;

class TimeTrackingPresenterImpl implements TimeTrackingPresenter {
    @Override
    public TimeTrackingDTO present(TimeTracking timeTracking) {
        return TImeTrackingMapper.INSTANCE.toDTO(timeTracking);
    }
}
