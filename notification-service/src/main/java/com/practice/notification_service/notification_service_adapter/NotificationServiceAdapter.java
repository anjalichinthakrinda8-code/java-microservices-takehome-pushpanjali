package com.practice.notification_service.notification_service_adapter;

import com.practice.notification_service.Kafka_adapter.NotificationKafkaPublisher;
import com.practice.notification_service.Kafka_adapter.NotificationSucceededEvent;
import com.practice.notification_service.common.NotificationServiceConstants;
import com.practice.notification_service.notification_service.NotificationRequest;
import com.practice.notification_service.notification_service.NotificationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceAdapter {
    private final NotificationServiceTransactionJPAClient notificationServiceTransactionJPAClient;
    private final NotificationKafkaPublisher notificationKafkaPublisher;

    public void saveNotificationDetails(NotificationRequest notificationRequest) {
        try {
            log.info("PaymentServiceAdapter processPayment:{} ", notificationRequest);

            NotificationServiceTransactionEntity notificationServiceTransactionEntity = new NotificationServiceTransactionEntity();
            notificationServiceTransactionEntity.setOrderId(notificationRequest.getOrderId());
            notificationServiceTransactionEntity.setPaymentAmt(notificationRequest.getAmount());
            notificationServiceTransactionEntity.setNotificationDate(LocalDateTime.now());
            notificationServiceTransactionEntity.setPaymentId(notificationRequest.getPaymentId());
            notificationServiceTransactionEntity = notificationServiceTransactionJPAClient.save(notificationServiceTransactionEntity);
            log.info("NotificationServiceAdapter processPayment object:{} ", notificationServiceTransactionEntity);

            NotificationSucceededEvent paymentEvent = new NotificationSucceededEvent(
                    notificationServiceTransactionEntity.getNotificationId(),
                    NotificationServiceConstants.NOTIFICATION_SUCCESS_MESSAGE

            );
            notificationKafkaPublisher.notificationEventPublisher(paymentEvent);
            log.info("NotificationServiceAdapter notification successfully published.");

        } catch (Exception e) {
            log.error("Exception occurred while processing the notification ", e);
        }

    }

    public List<NotificationResponse> fetchAllNotificationRecords() {
        log.info("PaymentServiceAdapter fetchAllNotificationRecords...");
        return notificationServiceTransactionJPAClient.findAll()
                .stream()
                .map(this::mapToNotificationDetails)
                .toList();
    }

    private NotificationResponse mapToNotificationDetails(NotificationServiceTransactionEntity payment) {
        return NotificationResponse.builder()
                .orderId(payment.getOrderId())
                .amount(payment.getPaymentAmt())
                .paymentId(payment.getPaymentId())
                .notificationId(payment.getNotificationId())
                .notificationDate(payment.getNotificationDate())
                .build();
    }
}
