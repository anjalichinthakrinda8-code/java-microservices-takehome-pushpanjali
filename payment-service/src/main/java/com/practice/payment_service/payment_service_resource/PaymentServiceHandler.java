package com.practice.payment_service.payment_service_resource;

import com.practice.payment_service.payment_service.PaymentResponse;
import com.practice.payment_service.payment_service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class PaymentServiceHandler {
    private final PaymentService paymentService;

    public List<PaymentResponse> fetchAllPaymentRecords() {
        return paymentService.fetchAllPaymentRecords();
    }
}
