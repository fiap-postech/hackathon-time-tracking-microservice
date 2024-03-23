package br.com.fiap.hackathon.time.tracking.launcher.messaging;

import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;
import br.com.fiap.hackathon.time.tracking.launcher.service.ReceiveEventService;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReceiveTimeTrackingEventListener {

    private final ReceiveEventService service;

    @SqsListener("local-hackathon-time-sheet-time-tracking-event-queue")
    public void listen(Message<TimeTrackingEvent> message) {
        service.receive(message.getPayload());
    }
}
