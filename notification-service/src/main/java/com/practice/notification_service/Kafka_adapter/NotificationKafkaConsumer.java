package com.practice.notification_service.Kafka_adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.notification_service.notification_service.NotificationRequest;
import com.practice.notification_service.notification_service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationKafkaConsumer {

    private final NotificationService notificationService;

    @KafkaListener(topics = "payment-succeeded-topic", groupId = "notification-service-group-v1", containerFactory = "kafkaListenerContainerFactory")
    public void consume(PaymentSucceededEvent paymentInfo) {
        log.info("Consumed PaymentSucceededEvent from Kafka: {}", paymentInfo);
        try {
            NotificationRequest notificationRequest = new NotificationRequest(
                    paymentInfo.getOrderId(),
                    paymentInfo.getAmount(),
                    paymentInfo.getPaymentId()
            );

            notificationService.saveNotificationDetails(notificationRequest);
            log.info("Notification processed for OrderId: {}", paymentInfo.getOrderId());
        } catch (Exception e) {
            log.error("Exception occurred while notifying the paymentData ", e);
        }
    }
}
