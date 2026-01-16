package com.practice.order_service.spring_adapter;

import com.practice.order_service.order_service.OrderAdapter;
import com.practice.order_service.order_service.OrderService;
import com.practice.order_service.order_service_adapter.OrderServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceBeansConfig {

    @Bean
    public OrderService OrderService(OrderServiceAdapter orderServiceAdapter){
        return new OrderAdapter(orderServiceAdapter);
    }
}
