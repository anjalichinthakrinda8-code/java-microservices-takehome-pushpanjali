package com.practice.notification_service.spring_adapter;

import com.practice.notification_service.notification_service.NotificationAdapter;
import com.practice.notification_service.notification_service.NotificationService;
import com.practice.notification_service.notification_service_adapter.NotificationServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationServiceBeansConfig {

    @Bean
    public NotificationService SendNotification(NotificationServiceAdapter notificationServiceAdapter) {
        return new NotificationAdapter(notificationServiceAdapter);
    }

}
