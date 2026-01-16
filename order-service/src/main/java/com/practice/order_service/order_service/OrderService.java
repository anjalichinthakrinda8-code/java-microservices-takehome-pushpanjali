package com.practice.order_service.order_service;

import jakarta.validation.Valid;

import java.util.List;

public interface OrderService {

    CreateOrderResponse createOrder(@Valid CreateOrderRequest request);

    List<CreateOrderResponse> fetchAllOrders();
}
