package br.com.fiap.hackathon.time.tracking.driven.event.producer;

import io.awspring.cloud.sns.core.TopicArnResolver;
import io.awspring.cloud.sns.core.TopicsListingTopicArnResolver;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
@ComponentScan(basePackages = "br.com.fiap.hackathon.time.tracking.driven.event.producer")
@EnableAsync
@AllArgsConstructor
public class TimeTrackingEventProducerConfiguration {

    @Bean
    public TopicArnResolver topicArnResolver(SnsClient snsClient) {
        return new TopicsListingTopicArnResolver(snsClient);
    }
}