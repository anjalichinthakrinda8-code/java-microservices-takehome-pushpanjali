package com.practice.notification_service.notification_service;

import com.practice.notification_service.notification_service_adapter.NotificationServiceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class NotificationAdapter implements NotificationService {

    private final NotificationServiceAdapter notificationServiceAdapter;

    @Override
    public List<NotificationResponse> fetchAllNotificationRecords() {
        return notificationServiceAdapter.fetchAllNotificationRecords();
    }

    @Override
    public void saveNotificationDetails(NotificationRequest request) {
        notificationServiceAdapter.saveNotificationDetails(request);
    }
}
