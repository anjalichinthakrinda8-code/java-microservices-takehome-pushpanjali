package com.practice.payment_service.payment_service;


import com.practice.payment_service.payment_service_adapter.PaymentServiceAdapter;
import com.practice.payment_service.payment_service_adapter.PaymentServiceTestDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentAdapterTest {

    @InjectMocks
    private PaymentAdapter paymentAdapter;

    @Mock
    private PaymentServiceAdapter paymentServiceAdapter;

    @Test
    public void testCreatePaymentRecord(){
        PaymentRequest req = PaymentServiceTestDataProvider.getPaymentRequest();
        paymentAdapter.createPaymentRecord(req);
    }

    @Test
    public void testFetchPayment(){
        List<PaymentResponse> res = PaymentServiceTestDataProvider.getAllPaymentResponse();
        when(paymentServiceAdapter.fetchAllPaymentRecords()).thenReturn(res);
        List<PaymentResponse> paymentResponse = paymentAdapter.fetchAllPaymentRecords();
        assertEquals(paymentResponse.size() , 2);

    }
}
