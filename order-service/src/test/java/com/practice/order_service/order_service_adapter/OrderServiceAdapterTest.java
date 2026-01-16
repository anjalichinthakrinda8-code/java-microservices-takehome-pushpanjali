package com.practice.order_service.order_service_adapter;

import com.practice.order_service.kafka_adapter.OrderEventPublisher;
import com.practice.order_service.order_service.CreateOrderRequest;
import com.practice.order_service.order_service.CreateOrderResponse;
import com.practice.order_service.kafka_adapter.OrderCreatedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceAdapterTest {

    @InjectMocks
    private OrderServiceAdapter orderServiceAdapter;

    @Mock
    private  OrderServiceTransactionJPAClient orderServiceTransactionJPAClient;

    @Mock
    private  OrderServiceMapper orderServiceMapper;

    @Mock
    private OrderEventPublisher eventPublisher;

    @Test
    public void testUpdateOrder(){
        OrderServiceTransactionEntity orderServiceTransactionEntity = OrderServiceTestDataProvider.getOrderServiceTransactionEntityData();
        CreateOrderRequest req = OrderServiceTestDataProvider.getCreateOrderRequest();
        CreateOrderResponse res = OrderServiceTestDataProvider.getUpdateOrderResponse();
        when(orderServiceTransactionJPAClient.findByCustomerEmail(any())).thenReturn(orderServiceTransactionEntity);
        when(orderServiceTransactionJPAClient.updateOrder(any(),any(),any())).thenReturn(1);
        when(orderServiceMapper.mapToUpdateOrderResponse(any())).thenReturn(res);
        CreateOrderResponse createOrderResponse = orderServiceAdapter.createOrder(req);
        assertEquals(createOrderResponse.getOrderId() , "0af866ef-838b-45fd-99f7-8584fe76afab");
        assertEquals(createOrderResponse.getMessage() , "Order details updated successfully");
    }

    @Test
    public void testCreateOrder(){
        CreateOrderRequest req = OrderServiceTestDataProvider.getCreateOrderRequest();
        CreateOrderResponse res = OrderServiceTestDataProvider.getCreateOrderResponse();
        OrderServiceTransactionEntity orderServiceTransactionEntity = OrderServiceTestDataProvider.getOrderServiceTransactionEntityData();
        when(orderServiceTransactionJPAClient.findByCustomerEmail(any())).thenReturn(null);
        when(orderServiceTransactionJPAClient.save(any())).thenReturn(orderServiceTransactionEntity);
        when(orderServiceMapper.mapToCreateOrderResponse(any())).thenReturn(res);
        doNothing().when(eventPublisher).orderEventPublisher(any(OrderCreatedEvent.class));
        CreateOrderResponse createOrderResponse = orderServiceAdapter.createOrder(req);
        assertEquals(createOrderResponse.getOrderId() , "cc67593d-bf75-4c7d-90eb-6c56eeae1160");
        assertEquals(createOrderResponse.getMessage() , "Order created successfully");
    }

    @Test
    public void testCreateOrderException(){
        CreateOrderRequest req = OrderServiceTestDataProvider.getCreateOrderRequest();
        CreateOrderResponse res = OrderServiceTestDataProvider.getCreateOrderErrorResponse();
        when(orderServiceTransactionJPAClient.findByCustomerEmail(any())).thenThrow(new RuntimeException("Error"));
        when(orderServiceMapper.mapToCreateOrderException()).thenReturn(res);
        CreateOrderResponse createOrderResponse = orderServiceAdapter.createOrder(req);
        assertEquals(createOrderResponse.getMessage() , "Exception occurred while creating the Order");
    }

    @Test
    public void testFetchAllRecords(){
        List<OrderServiceTransactionEntity> res = OrderServiceTestDataProvider.getOrderServiceTransactionEntityDataList();
        when(orderServiceTransactionJPAClient.findAll()).thenReturn(res);
        List<CreateOrderResponse>  createOrderResponse = orderServiceAdapter.fetchAllOrders();
        assertEquals(createOrderResponse.size() , 2);
    }
}
