package com.practice.order_service.order_service_resource;


import com.practice.order_service.order_service.CreateOrderRequest;
import com.practice.order_service.order_service.CreateOrderResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@Validated
public class OrderServiceController {
    private final OrderServiceHandler orderServiceHandler;

    @PostMapping(value="${create-order.endpoint:/api/orders}", consumes="application/json", produces="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateOrderResponse createOrder(@RequestBody  @Valid CreateOrderRequest request) {
        return orderServiceHandler.createOrder(request);
    }

    @GetMapping(value="${fetch-order.endpoint:/api/orders}", consumes="application/json", produces="application/json")
    public List<CreateOrderResponse> fetchAllOrders() {
        return orderServiceHandler.fetchAllOrders();
    }
}
