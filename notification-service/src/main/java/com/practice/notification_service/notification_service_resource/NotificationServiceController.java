package com.practice.notification_service.notification_service_resource;


import com.practice.notification_service.notification_service.NotificationResponse;
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
public class NotificationServiceController {
    private final NotificationServiceHandler notificationServiceHandler;

    @GetMapping(value = "${notification.event.endpoint:/api/notifications}", consumes = "application/json", produces = "application/json")
    public List<NotificationResponse> fetchAllNotificationRecords() {
        return notificationServiceHandler.fetchAllNotificationRecords();
    }
}
