package com.practice.order_service.order_service_adapter;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "ORDER_ENTRY")
public class OrderServiceTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ORDERE_ID", nullable = false)
    private String orderId;

    @Column(name = "ORDERED_AMT", nullable = false)
    private BigDecimal orderedAmt;

    @Column(name = "CUSTOMER_EMAIL", nullable = false)
    private String customerEmail;

    @Column(name = "ORDERED_DATE", nullable = false)
    private LocalDateTime orderedDate;

    @Column(name = "ORDER_UPDATED_DATE", nullable = true)
    private LocalDateTime orderUpdatedDate;
}
