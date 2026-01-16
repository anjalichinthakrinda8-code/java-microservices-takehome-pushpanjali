package com.practice.payment_service.payment_service;

import com.practice.payment_service.payment_service_adapter.PaymentServiceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PaymentAdapter implements PaymentService {

    private final PaymentServiceAdapter paymentServiceAdapter;

    @Override
    public List<PaymentResponse> fetchAllPaymentRecords() {
        return paymentServiceAdapter.fetchAllPaymentRecords();
    }

    @Override
    public void createPaymentRecord(PaymentRequest request) {
        paymentServiceAdapter.processPayment(request);
    }
}
