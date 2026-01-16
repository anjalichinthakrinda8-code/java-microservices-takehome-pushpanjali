package com.practice.payment_service.payment_service_resource;


import com.practice.payment_service.payment_service.PaymentResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@Validated
public class PaymentServiceController {
    private final PaymentServiceHandler paymentServiceHandler;

    @GetMapping(value = "${fetch-payment.endpoint:/api/payments}", consumes = "application/json", produces = "application/json")
    public List<PaymentResponse> fetchAllPaymentRecords() {
        return paymentServiceHandler.fetchAllPaymentRecords();
    }
}
