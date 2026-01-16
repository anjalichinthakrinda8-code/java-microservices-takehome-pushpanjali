package com.practice.payment_service.Kafka_adapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.payment_service.payment_service.PaymentRequest;
import com.practice.payment_service.payment_service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentKafkaConsumer {

    private final PaymentService paymentService;

    @KafkaListener(topics = "order-created-topic", groupId = "payment-service-group-v1", containerFactory = "kafkaListenerContainerFactory")
    public void consume(OrderCreatedEvent orderInfo) {
        log.info("Consumed OrderCreatedEvent from Kafka: {}", orderInfo);
        try {
            PaymentRequest paymentRequest = new PaymentRequest(
                    orderInfo.getOrderId(),
                    orderInfo.getOrderedAmt()
            );

            paymentService.createPaymentRecord(paymentRequest);
            log.info("Payment processed for OrderId: {}", orderInfo.getOrderId());
        } catch (Exception e) {
            log.error("Exception occurred while consuming the orderData ", e);
        }
    }
}
