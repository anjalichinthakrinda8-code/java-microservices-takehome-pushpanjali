package com.practice.notification_service.notification_service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class NotificationRequest {
    private String orderId;
    private BigDecimal amount;
    private String paymentId;
}
