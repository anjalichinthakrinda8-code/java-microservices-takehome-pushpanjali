package com.practice.order_service.order_service_resource;

import com.practice.order_service.order_service.CreateOrderRequest;
import com.practice.order_service.order_service.CreateOrderResponse;
import com.practice.order_service.order_service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class OrderServiceHandler {
    private final OrderService orderService;

    public CreateOrderResponse createOrder(@Valid CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    public List<CreateOrderResponse> fetchAllOrders() {
        return orderService.fetchAllOrders();
    }
}
