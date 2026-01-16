package com.practice.payment_service.spring_adapter;

import com.practice.payment_service.payment_service.PaymentAdapter;
import com.practice.payment_service.payment_service.PaymentService;
import com.practice.payment_service.payment_service_adapter.PaymentServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServiceBeansConfig {

    @Bean
    public PaymentService OrderService(PaymentServiceAdapter paymentServiceAdapter) {
        return new PaymentAdapter(paymentServiceAdapter);
    }

}
