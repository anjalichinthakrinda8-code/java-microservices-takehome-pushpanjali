package com.practice.order_service.kafka_adapter;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderCreatedEvent {
    private String orderId;
    private BigDecimal orderedAmt;
    private LocalDateTime orderedDate;
    private LocalDateTime orderUpdatedDate;
    private String customerEmail;
}
