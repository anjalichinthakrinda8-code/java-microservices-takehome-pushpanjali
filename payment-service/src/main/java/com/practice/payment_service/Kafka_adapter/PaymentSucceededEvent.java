package com.practice.payment_service.Kafka_adapter;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSucceededEvent {
    private String orderId;
    private String paymentId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}
