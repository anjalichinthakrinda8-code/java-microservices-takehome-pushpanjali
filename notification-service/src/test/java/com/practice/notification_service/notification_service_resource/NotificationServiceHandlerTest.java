package com.practice.notification_service.notification_service_resource;

import com.practice.notification_service.notification_service.NotificationResponse;
import com.practice.notification_service.notification_service.NotificationService;
import com.practice.notification_service.notification_service_adapter.NotificationServiceTestDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceHandlerTest {

    @Mock
    private NotificationService paymentService;

    @InjectMocks
    private NotificationServiceHandler orderServiceHandler;

    @Test
    public void testFetchAllOrders() {
        List<NotificationResponse> res = NotificationServiceTestDataProvider.getAllPaymentResponse();
        when(paymentService.fetchAllNotificationRecords()).thenReturn(res);
        List<NotificationResponse> notificationResponse = orderServiceHandler.fetchAllNotificationRecords();
        assertEquals(notificationResponse.size(), 2);
    }
}
