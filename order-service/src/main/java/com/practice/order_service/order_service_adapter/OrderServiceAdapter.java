package com.practice.order_service.order_service_adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.order_service.kafka_adapter.OrderCreatedEvent;
import com.practice.order_service.kafka_adapter.OrderEventPublisher;
import com.practice.order_service.order_service.CreateOrderRequest;
import com.practice.order_service.order_service.CreateOrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderServiceAdapter {
    private final OrderServiceTransactionJPAClient orderServiceTransactionJPAClient;
    private final OrderServiceMapper orderServiceMapper;
    private final OrderEventPublisher orderEventPublisher;

    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        try {
            log.info("OrderServiceAdapter createOrderRequest:{} ", createOrderRequest);

            OrderServiceTransactionEntity orderedData = orderServiceTransactionJPAClient.findByCustomerEmail(createOrderRequest.getCustomerEmail());
            log.info("OrderServiceAdapter orderedData:{}  ", orderedData);

            if (ObjectUtils.isEmpty(orderedData)) {
                OrderServiceTransactionEntity orderServiceTransactionEntity = new OrderServiceTransactionEntity();
                orderServiceTransactionEntity.setCustomerEmail(createOrderRequest.getCustomerEmail());
                orderServiceTransactionEntity.setOrderedAmt(createOrderRequest.getAmount());
                orderServiceTransactionEntity.setOrderedDate(LocalDateTime.now());
                orderServiceTransactionEntity = orderServiceTransactionJPAClient.save(orderServiceTransactionEntity);
                log.info("OrderServiceAdapter order created:{} ", orderServiceTransactionEntity);

                OrderCreatedEvent event = getOrderCreatedEvent(orderServiceTransactionEntity);
                orderEventPublisher.orderEventPublisher(event);


                log.info("OrderServiceAdapter order created data published.");
                return orderServiceMapper.mapToCreateOrderResponse(orderServiceTransactionEntity.getOrderId());

            } else {
                orderServiceTransactionJPAClient.updateOrder(createOrderRequest.getAmount(), LocalDateTime.now(), createOrderRequest.getCustomerEmail());
                log.info("OrderServiceAdapter order updated for orderId: {}", orderedData.getOrderId());
                return orderServiceMapper.mapToUpdateOrderResponse(orderedData.getOrderId());
            }
        }catch(Exception e){
            log.error("Exception occurred while creating the Order ", e);
            return orderServiceMapper.mapToCreateOrderException();
        }

    }

    public List<CreateOrderResponse> fetchAllOrders() {
        log.info("OrderServiceAdapter fetchAllOrders...");
        return orderServiceTransactionJPAClient.findAll()
                .stream()
                .map(this::mapToOrderDetails)
                .toList();
    }

    private CreateOrderResponse mapToOrderDetails(OrderServiceTransactionEntity order) {
        return CreateOrderResponse.builder()
                .orderId(order.getOrderId())
                .amount(order.getOrderedAmt())
                .customerEmail(order.getCustomerEmail())
                .orderUpdatedDate(order.getOrderUpdatedDate())
                .orderedDate(order.getOrderedDate())
                .build();
    }

    private OrderCreatedEvent getOrderCreatedEvent(OrderServiceTransactionEntity orderServiceTransactionEntity) {
        return new OrderCreatedEvent(
                orderServiceTransactionEntity.getOrderId(),
                orderServiceTransactionEntity.getOrderedAmt(),
                orderServiceTransactionEntity.getOrderedDate(),
                orderServiceTransactionEntity.getOrderUpdatedDate(),
                orderServiceTransactionEntity.getCustomerEmail()
        );
    }
}
