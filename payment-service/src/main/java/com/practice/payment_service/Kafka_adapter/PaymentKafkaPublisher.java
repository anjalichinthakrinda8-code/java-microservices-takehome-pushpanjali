package com.practice.payment_service.Kafka_adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentKafkaPublisher {

    private final KafkaTemplate<String, PaymentSucceededEvent> kafkaTemplate;

    @Value("${payment.succeeded.topic}")
    private String paymentSucceededTopic;

    public void paymentEventPublisher(PaymentSucceededEvent event) {
        kafkaTemplate.send(paymentSucceededTopic, event.getPaymentId(), event);
        System.out.println("Published paymentEventPublisher to Kafka: " + event.getOrderId());
    }
}
