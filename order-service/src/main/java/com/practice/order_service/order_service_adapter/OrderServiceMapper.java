package com.practice.order_service.order_service_adapter;

import com.practice.order_service.common.OrderServiceConstants;
import com.practice.order_service.order_service.CreateOrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderServiceMapper {
    public CreateOrderResponse mapToCreateOrderException() {
        return CreateOrderResponse.builder()
                .code(OrderServiceConstants.CODE_500)
                .message(OrderServiceConstants.CREATE_ORDER_ERROR_MESSAGE)
                .status(OrderServiceConstants.FAILURE)
                .build();
    }

    public CreateOrderResponse mapToCreateOrderResponse(String orderId) {
        return CreateOrderResponse.builder()
                .orderId(orderId)
                .code(OrderServiceConstants.CODE_200)
                .message(OrderServiceConstants.CREATE_ORDER_SUCCESS_MESSAGE)
                .status(OrderServiceConstants.SUCCESS)
                .build();
    }

    public CreateOrderResponse mapToUpdateOrderResponse(String orderId) {
        return CreateOrderResponse.builder()
                .orderId(orderId)
                .code(OrderServiceConstants.CODE_200)
                .message(OrderServiceConstants.UPDATE_ORDER_SUCCESS_MESSAGE)
                .status(OrderServiceConstants.SUCCESS)
                .build();
    }

}
