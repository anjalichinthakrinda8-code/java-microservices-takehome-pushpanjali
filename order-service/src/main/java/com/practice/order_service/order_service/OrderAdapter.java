package com.practice.order_service.order_service;

import com.practice.order_service.order_service_adapter.OrderServiceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class OrderAdapter implements OrderService{

    private final OrderServiceAdapter orderServiceAdapter;

    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) {
        return orderServiceAdapter.createOrder(request);
    }

    @Override
    public List<CreateOrderResponse> fetchAllOrders() {
        return orderServiceAdapter.fetchAllOrders();
    }
}
