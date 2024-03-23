package br.com.fiap.hackathon.time.tracking.launcher.service;

import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReceiveEventService {

    public void receive(TimeTrackingEvent event){
        LoggerFactory.getLogger(ReceiveEventService.class).info(event.getEmployeeId());
    }

}
