package com.practice.notification_service.Kafka_adapter;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationSucceededEvent {
    private String notificationId;
    private String message;
}
