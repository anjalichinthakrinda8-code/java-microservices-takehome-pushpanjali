package com.practice.payment_service.payment_service_adapter;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentServiceTransactionJPAClient extends JpaRepository<PaymentServiceTransactionEntity, String> {
}