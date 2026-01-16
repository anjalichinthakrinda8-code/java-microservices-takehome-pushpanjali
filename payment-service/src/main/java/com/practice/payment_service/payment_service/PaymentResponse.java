package com.practice.payment_service.payment_service;

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
public class PaymentResponse {
    private String code;
    private String message;
    private String status;
    private String orderId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private String paymentId;
}
