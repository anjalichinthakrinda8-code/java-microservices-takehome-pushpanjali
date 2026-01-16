package com.practice.payment_service.payment_service_adapter;

import com.practice.payment_service.Kafka_adapter.PaymentKafkaPublisher;
import com.practice.payment_service.Kafka_adapter.PaymentSucceededEvent;
import com.practice.payment_service.payment_service.PaymentRequest;
import com.practice.payment_service.payment_service.PaymentResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceAdapterTest {

    @InjectMocks
    private PaymentServiceAdapter paymentServiceAdapter;

    @Mock
    private PaymentServiceTransactionJPAClient paymentServiceTransactionJPAClient;

    @Mock
    private PaymentKafkaPublisher eventPublisher;

    @Test
    public void testProcessPayment() {
        PaymentRequest req = PaymentServiceTestDataProvider.getPaymentRequest();
        PaymentServiceTransactionEntity paymentServiceTransactionEntity = PaymentServiceTestDataProvider.getPaymentServiceTransactionEntityData();
        when(paymentServiceTransactionJPAClient.save(any())).thenReturn(paymentServiceTransactionEntity);
        doNothing().when(eventPublisher).paymentEventPublisher(any(PaymentSucceededEvent.class));
        paymentServiceAdapter.processPayment(req);
    }

    @Test
    public void testFetchAllPaymentRecords() {
        List<PaymentServiceTransactionEntity> res = PaymentServiceTestDataProvider.getPaymemntServiceTransactionEntityDataList();
        when(paymentServiceTransactionJPAClient.findAll()).thenReturn(res);
        List<PaymentResponse> paymentResponse = paymentServiceAdapter.fetchAllPaymentRecords();
        assertEquals(paymentResponse.size(), 2);
    }
}
