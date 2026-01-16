package com.practice.payment_service.payment_service;

import java.util.List;

public interface PaymentService {
    List<PaymentResponse> fetchAllPaymentRecords();
    void createPaymentRecord(PaymentRequest request);
}
