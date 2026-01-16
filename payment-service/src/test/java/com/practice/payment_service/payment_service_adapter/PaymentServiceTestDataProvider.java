package com.practice.payment_service.payment_service_adapter;


import com.practice.payment_service.payment_service.PaymentRequest;
import com.practice.payment_service.payment_service.PaymentResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class PaymentServiceTestDataProvider {

    private PaymentServiceTestDataProvider() {

    }

    public static PaymentRequest getPaymentRequest() {
        return PaymentRequest.builder()
                .amount(BigDecimal.valueOf(6500))
                .orderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160")
                .build();
    }

    public static List<PaymentResponse> getAllPaymentResponse() {
        PaymentResponse paymentResponse1 = PaymentResponse.builder()
                .amount(BigDecimal.valueOf(6500))
                .paymentDate(LocalDateTime.now())
                .orderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160")
                .paymentId("0af866ef-rert-99f7-8584fe76afab")
                .build();
        PaymentResponse paymentResponse2 = PaymentResponse.builder()
                .amount(BigDecimal.valueOf(9500))
                .paymentDate(LocalDateTime.now())
                .orderId("09647593d-bf75-4c7d-90eb-6c56eeae1160")
                .paymentId("0af866ef-retyu-99f7-8584fe76afab")
                .build();
        List<PaymentResponse> resList = new ArrayList<>();
        resList.add(paymentResponse1);
        resList.add(paymentResponse2);

        return resList;
    }


    public static List<PaymentServiceTransactionEntity> getPaymemntServiceTransactionEntityDataList() {
        PaymentServiceTransactionEntity entity = new PaymentServiceTransactionEntity();
        entity.setOrderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160");
        entity.setPaymentId("965440-bf75-4c7d-90eb-6c56eeae1160");
        entity.setPaymentDate(LocalDateTime.now());
        entity.setPaymentAmt(BigDecimal.valueOf(6500));

        PaymentServiceTransactionEntity entity1 = new PaymentServiceTransactionEntity();
        entity.setOrderId("d76576-bf75-4c7d-90eb-6c56eeae1160");
        entity.setPaymentId("p43768-bf75-4c7d-90eb-6c56eeae1160");
        entity.setPaymentDate(LocalDateTime.now());
        entity.setPaymentAmt(BigDecimal.valueOf(9000));

        List<PaymentServiceTransactionEntity> resList = new ArrayList<>();
        resList.add(entity);
        resList.add(entity1);

        return resList;
    }

    public static PaymentServiceTransactionEntity getPaymentServiceTransactionEntityData() {
        PaymentServiceTransactionEntity entity = new PaymentServiceTransactionEntity();
        entity.setOrderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160");
        entity.setPaymentId("965440-bf75-4c7d-90eb-6c56eeae1160");
        entity.setPaymentDate(LocalDateTime.now());
        entity.setPaymentAmt(BigDecimal.valueOf(6500));
        return entity;
    }


}