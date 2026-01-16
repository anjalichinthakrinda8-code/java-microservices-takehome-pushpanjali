package com.practice.order_service.order_service;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateOrderResponse {
    private String code;
    private String message;
    private String status;
    private String orderId;
    private BigDecimal amount;
    private LocalDateTime orderedDate;
    private LocalDateTime orderUpdatedDate;
    private String customerEmail;
}
