package com.practice.order_service.kafka_adapter;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderEventPublisher {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    @Value("${order.created.topic}")
    private String orderCreatedTopic;

    public void orderEventPublisher(OrderCreatedEvent event) {
        kafkaTemplate.send(orderCreatedTopic, event.getOrderId(), event);
        kafkaTemplate.flush();
        System.out.println("Published OrderCreatedEvent to Kafka: " + event.getOrderId());
    }

}
