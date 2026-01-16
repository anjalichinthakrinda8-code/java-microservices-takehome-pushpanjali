package com.practice.payment_service.payment_service_adapter;

import com.practice.payment_service.Kafka_adapter.PaymentKafkaPublisher;
import com.practice.payment_service.Kafka_adapter.PaymentSucceededEvent;
import com.practice.payment_service.payment_service.PaymentRequest;
import com.practice.payment_service.payment_service.PaymentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceAdapter {
    private final PaymentServiceTransactionJPAClient paymentServiceTransactionJPAClient;
    private final PaymentKafkaPublisher paymentKafkaPublisher;

    public void processPayment(PaymentRequest paymentRequest) {
        try {
            log.info("PaymentServiceAdapter processPayment:{} ", paymentRequest);

            PaymentServiceTransactionEntity paymentServiceTransactionEntity = new PaymentServiceTransactionEntity();
            paymentServiceTransactionEntity.setOrderId(paymentRequest.getOrderId());
            paymentServiceTransactionEntity.setPaymentAmt(paymentRequest.getAmount());
            paymentServiceTransactionEntity.setPaymentDate(LocalDateTime.now());
            paymentServiceTransactionEntity = paymentServiceTransactionJPAClient.save(paymentServiceTransactionEntity);
            log.info("PaymentServiceAdapter processPayment object:{} ", paymentServiceTransactionEntity);

            PaymentSucceededEvent paymentEvent = new PaymentSucceededEvent(
                    paymentServiceTransactionEntity.getOrderId(),
                    paymentServiceTransactionEntity.getPaymentId(),
                    paymentServiceTransactionEntity.getPaymentAmt(),
                    paymentServiceTransactionEntity.getPaymentDate()
            );
            paymentKafkaPublisher.paymentEventPublisher(paymentEvent);
            log.info("PaymentServiceAdapter payment details successfully published.");

        } catch (Exception e) {
            log.error("Exception occurred while processing the payment ", e);
        }

    }

    public List<PaymentResponse> fetchAllPaymentRecords() {
        log.info("PaymentServiceAdapter fetchAllPaymentRecords...");
        return paymentServiceTransactionJPAClient.findAll()
                .stream()
                .map(this::mapToPaymentDetails)
                .toList();
    }

    private PaymentResponse mapToPaymentDetails(PaymentServiceTransactionEntity payment) {
        return PaymentResponse.builder()
                .orderId(payment.getOrderId())
                .amount(payment.getPaymentAmt())
                .paymentId(payment.getPaymentId())
                .paymentDate(payment.getPaymentDate())
                .build();
    }
}
