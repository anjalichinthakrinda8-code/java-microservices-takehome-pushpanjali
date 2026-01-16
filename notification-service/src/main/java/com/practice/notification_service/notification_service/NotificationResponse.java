package com.practice.notification_service.notification_service;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationResponse {
    private String orderId;
    private BigDecimal amount;
    private LocalDateTime notificationDate;
    private String paymentId;
    private String notificationId;
}
