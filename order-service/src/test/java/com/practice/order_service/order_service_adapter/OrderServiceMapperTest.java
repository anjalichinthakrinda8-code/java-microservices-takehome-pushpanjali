package com.practice.order_service.order_service_adapter;

import com.practice.order_service.order_service.CreateOrderResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OrderServiceMapperTest {

    @InjectMocks
    private OrderServiceMapper OrderServiceMapper;

    @Test
    public void testMapToCreateOrderException(){
        CreateOrderResponse createOrderResponse = OrderServiceMapper.mapToCreateOrderException();
        assertEquals("500" , createOrderResponse.getCode());
    }

    @Test
    public void testMapToCreateOrderResponse(){
        String orderId = "0af866ef-838b-45fd-99f7-8584fe76afab";
        CreateOrderResponse createOrderResponse = OrderServiceMapper.mapToCreateOrderResponse(orderId);
        assertEquals("200" , createOrderResponse.getCode());
    }

    @Test
    public void testMapToUpdateOrderResponse(){
        String orderId = "0af866ef-838b-45fd-99f7-8584fe76afab";
        CreateOrderResponse createOrderResponse = OrderServiceMapper.mapToUpdateOrderResponse(orderId);
        assertEquals("200" , createOrderResponse.getCode());
    }
}
