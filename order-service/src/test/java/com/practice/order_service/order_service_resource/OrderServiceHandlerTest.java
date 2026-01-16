package com.practice.order_service.order_service_resource;

import com.practice.order_service.order_service.CreateOrderRequest;
import com.practice.order_service.order_service.CreateOrderResponse;
import com.practice.order_service.order_service.OrderService;
import com.practice.order_service.order_service_adapter.OrderServiceTestDataProvider;
import com.practice.order_service.order_service_adapter.OrderServiceTransactionEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceHandlerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderServiceHandler orderServiceHandler;

    @Test
    public void testCreateOrder(){
        CreateOrderRequest req = OrderServiceTestDataProvider.getCreateOrderRequest();
        CreateOrderResponse res = OrderServiceTestDataProvider.getCreateOrderResponse();
        when(orderService.createOrder(any())).thenReturn(res);
        CreateOrderResponse createOrderResponse = orderServiceHandler.createOrder(req);
        assertEquals(createOrderResponse.getOrderId() , "cc67593d-bf75-4c7d-90eb-6c56eeae1160");
        assertEquals(createOrderResponse.getMessage() , "Order created successfully");
    }

    @Test
    public void testFetchAllOrders(){
        List<CreateOrderResponse>  res = OrderServiceTestDataProvider.getAllOrdersCreatedResponse();
        when(orderService.fetchAllOrders()).thenReturn(res);
        List<CreateOrderResponse> createOrderResponse = orderServiceHandler.fetchAllOrders();
        assertEquals(createOrderResponse.size() , 2);
    }
}
