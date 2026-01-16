package com.practice.order_service.order_service;


import com.practice.order_service.order_service_adapter.OrderServiceAdapter;
import com.practice.order_service.order_service_adapter.OrderServiceTestDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderAdapterTest {

    @InjectMocks
    private OrderAdapter orderAdapter;

    @Mock
    private OrderServiceAdapter orderServiceAdapter;

    @Test
    public void testCreateOrder(){
        CreateOrderRequest req = OrderServiceTestDataProvider.getCreateOrderRequest();
        CreateOrderResponse res = OrderServiceTestDataProvider.getCreateOrderResponse();
        when(orderServiceAdapter.createOrder(req)).thenReturn(res);
        CreateOrderResponse createOrderResponse = orderAdapter.createOrder(req);
        assertEquals(createOrderResponse.getOrderId() , "cc67593d-bf75-4c7d-90eb-6c56eeae1160");

    }

    @Test
    public void testFetchCreateOrder(){
        List<CreateOrderResponse> res = OrderServiceTestDataProvider.getAllOrdersCreatedResponse();
        when(orderServiceAdapter.fetchAllOrders()).thenReturn(res);
        List<CreateOrderResponse> createOrderResponse = orderAdapter.fetchAllOrders();
        assertEquals(createOrderResponse.size() , 2);

    }
}
