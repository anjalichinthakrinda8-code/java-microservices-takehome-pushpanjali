package com.practice.notification_service.notification_service;


import com.practice.notification_service.notification_service_adapter.NotificationServiceAdapter;
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
public class NotificationAdapterTest {

    @InjectMocks
    private NotificationAdapter paymentAdapter;

    @Mock
    private NotificationServiceAdapter notificationServiceAdapter;

    @Test
    public void testCreatePaymentRecord(){
        NotificationRequest req = NotificationServiceTestDataProvider.getPaymentRequest();
        paymentAdapter.saveNotificationDetails(req);
    }

    @Test
    public void testFetchPayment(){
        List<NotificationResponse> res = NotificationServiceTestDataProvider.getAllPaymentResponse();
        when(notificationServiceAdapter.fetchAllNotificationRecords()).thenReturn(res);
        List<NotificationResponse> notificationResponse = paymentAdapter.fetchAllNotificationRecords();
        assertEquals(notificationResponse.size() , 2);

    }
}
