package com.practice.notification_service.notification_service_resource;

import com.practice.notification_service.notification_service.NotificationResponse;
import com.practice.notification_service.notification_service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class NotificationServiceHandler {
    private final NotificationService notificationService;

    public List<NotificationResponse> fetchAllNotificationRecords() {
        return notificationService.fetchAllNotificationRecords();
    }
}
