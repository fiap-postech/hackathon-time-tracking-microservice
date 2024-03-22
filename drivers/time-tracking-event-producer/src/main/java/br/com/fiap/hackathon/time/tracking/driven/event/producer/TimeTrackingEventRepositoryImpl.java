package br.com.fiap.hackathon.time.tracking.driven.event.producer;

import br.com.fiap.hackathon.time.tracking.adapter.event.TimeTrackingEvent;
import br.com.fiap.hackathon.time.tracking.adapter.repository.TimeTrackingEventRepository;
import io.awspring.cloud.sns.core.SnsTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor
public class TimeTrackingEventRepositoryImpl implements TimeTrackingEventRepository {

    private static final String REGISTER_TIME_TRACKING_TOPIC_NAME = "aws.sns.registered-time-tracking.name";

    private final SnsTemplate sns;
    private final Environment env;

    @Override
    public void publish(TimeTrackingEvent event) {
        sns.convertAndSend(
                requireNonNull(env.getProperty(REGISTER_TIME_TRACKING_TOPIC_NAME)),
                event
        );
    }
}