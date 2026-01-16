package com.practice.notification_service.notification_service_adapter;

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
@Table(name = "NOTIFICATION")
public class NotificationServiceTransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "NOTIFICATION_ID", nullable = false)
    private String notificationId;

    @Column(name = "PAYMENT_ID", nullable = false)
    private String paymentId;

    @Column(name = "PAYMENT_AMT", nullable = false)
    private BigDecimal paymentAmt;

    @Column(name = "ORDER_ID", nullable = false)
    private String orderId;

    @Column(name = "NOTIFY_DATE", nullable = false)
    private LocalDateTime notificationDate;
}
