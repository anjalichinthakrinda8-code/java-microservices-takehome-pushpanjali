package com.practice.notification_service.notification_service_adapter;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationServiceTransactionJPAClient extends JpaRepository<NotificationServiceTransactionEntity, String> {
}