package com.practice.notification_service.Kafka_adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationKafkaPublisher {

    private final KafkaTemplate<String, NotificationSucceededEvent> kafkaTemplate;

    @Value("${notification.topic}")
    private String notificationTopic;

    public void notificationEventPublisher(NotificationSucceededEvent event) {
        kafkaTemplate.send(notificationTopic, event.getNotificationId(), event);
        System.out.println("Published paymentEventPublisher to Kafka: " + event.getNotificationId());
    }
}
