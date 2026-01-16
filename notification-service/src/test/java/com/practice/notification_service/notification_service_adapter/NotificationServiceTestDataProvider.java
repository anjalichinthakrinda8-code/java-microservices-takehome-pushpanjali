package com.practice.notification_service.notification_service_adapter;


import com.practice.notification_service.notification_service.NotificationRequest;
import com.practice.notification_service.notification_service.NotificationResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class NotificationServiceTestDataProvider {

    private NotificationServiceTestDataProvider() {

    }

    public static NotificationRequest getPaymentRequest() {
        return NotificationRequest.builder()
                .amount(BigDecimal.valueOf(6500))
                .orderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160")
                .build();
    }

    public static List<NotificationResponse> getAllPaymentResponse() {
        NotificationResponse notificationResponse1 = NotificationResponse.builder()
                .amount(BigDecimal.valueOf(6500))
                .notificationDate(LocalDateTime.now())
                .orderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160")
                .paymentId("0af866ef-rert-99f7-8584fe76afab")
                .build();
        NotificationResponse notificationResponse2 = NotificationResponse.builder()
                .amount(BigDecimal.valueOf(9500))
                .notificationDate(LocalDateTime.now())
                .orderId("09647593d-bf75-4c7d-90eb-6c56eeae1160")
                .paymentId("0af866ef-retyu-99f7-8584fe76afab")
                .build();
        List<NotificationResponse> resList = new ArrayList<>();
        resList.add(notificationResponse1);
        resList.add(notificationResponse2);

        return resList;
    }


    public static List<NotificationServiceTransactionEntity> getPaymemntServiceTransactionEntityDataList() {
        NotificationServiceTransactionEntity entity = new NotificationServiceTransactionEntity();
        entity.setOrderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160");
        entity.setPaymentId("965440-bf75-4c7d-90eb-6c56eeae1160");
        entity.setNotificationDate(LocalDateTime.now());
        entity.setPaymentAmt(BigDecimal.valueOf(6500));

        NotificationServiceTransactionEntity entity1 = new NotificationServiceTransactionEntity();
        entity.setOrderId("d76576-bf75-4c7d-90eb-6c56eeae1160");
        entity.setPaymentId("p43768-bf75-4c7d-90eb-6c56eeae1160");
        entity.setNotificationDate(LocalDateTime.now());
        entity.setPaymentAmt(BigDecimal.valueOf(9000));

        List<NotificationServiceTransactionEntity> resList = new ArrayList<>();
        resList.add(entity);
        resList.add(entity1);

        return resList;
    }

    public static NotificationServiceTransactionEntity getPaymentServiceTransactionEntityData() {
        NotificationServiceTransactionEntity entity = new NotificationServiceTransactionEntity();
        entity.setOrderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160");
        entity.setPaymentId("965440-bf75-4c7d-90eb-6c56eeae1160");
        entity.setNotificationDate(LocalDateTime.now());
        entity.setPaymentAmt(BigDecimal.valueOf(6500));
        return entity;
    }


}