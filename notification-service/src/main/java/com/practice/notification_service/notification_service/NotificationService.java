package com.practice.notification_service.notification_service;

import java.util.List;

public interface NotificationService {
    List<NotificationResponse> fetchAllNotificationRecords();
    void saveNotificationDetails(NotificationRequest request);
}
