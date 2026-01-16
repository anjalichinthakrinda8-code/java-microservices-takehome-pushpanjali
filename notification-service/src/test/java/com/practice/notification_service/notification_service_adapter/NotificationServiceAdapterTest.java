package com.practice.notification_service.notification_service_adapter;

import com.practice.notification_service.Kafka_adapter.NotificationKafkaPublisher;
import com.practice.notification_service.Kafka_adapter.NotificationSucceededEvent;
import com.practice.notification_service.notification_service.NotificationRequest;
import com.practice.notification_service.notification_service.NotificationResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceAdapterTest {

    @InjectMocks
    private NotificationServiceAdapter notificationServiceAdapter;

    @Mock
    private NotificationServiceTransactionJPAClient notificationServiceTransactionJPAClient;

    @Mock
    private NotificationKafkaPublisher eventPublisher;

    @Test
    public void testProcessPayment() {
        NotificationRequest req = NotificationServiceTestDataProvider.getPaymentRequest();
        NotificationServiceTransactionEntity notificationServiceTransactionEntity = NotificationServiceTestDataProvider.getPaymentServiceTransactionEntityData();
        when(notificationServiceTransactionJPAClient.save(any())).thenReturn(notificationServiceTransactionEntity);
        doNothing().when(eventPublisher).notificationEventPublisher(any(NotificationSucceededEvent.class));
        notificationServiceAdapter.saveNotificationDetails(req);
    }

    @Test
    public void testFetchAllPaymentRecords() {
        List<NotificationServiceTransactionEntity> res = NotificationServiceTestDataProvider.getPaymemntServiceTransactionEntityDataList();
        when(notificationServiceTransactionJPAClient.findAll()).thenReturn(res);
        List<NotificationResponse> notificationResponse = notificationServiceAdapter.fetchAllNotificationRecords();
        assertEquals(notificationResponse.size(), 2);
    }
}
