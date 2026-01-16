package com.practice.payment_service.payment_service_resource;

import com.practice.payment_service.payment_service.PaymentResponse;
import com.practice.payment_service.payment_service.PaymentService;
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
public class PaymentServiceHandlerTest {

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private PaymentServiceHandler orderServiceHandler;

    @Test
    public void testFetchAllOrders() {
        List<PaymentResponse> res = PaymentServiceTestDataProvider.getAllPaymentResponse();
        when(paymentService.fetchAllPaymentRecords()).thenReturn(res);
        List<PaymentResponse> paymentResponse = orderServiceHandler.fetchAllPaymentRecords();
        assertEquals(paymentResponse.size(), 2);
    }
}
