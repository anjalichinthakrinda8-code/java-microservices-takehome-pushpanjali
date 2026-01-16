package com.practice.order_service.order_service_adapter;


import com.practice.order_service.order_service.CreateOrderRequest;
import com.practice.order_service.order_service.CreateOrderResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class OrderServiceTestDataProvider {

    private OrderServiceTestDataProvider(){

    }

    public static CreateOrderRequest getCreateOrderRequest(){
        return CreateOrderRequest.builder()
                .amount(BigDecimal.valueOf(6500))
                .customerEmail("testUser@example.com")
                .build();
    }

    public static List<CreateOrderResponse> getAllOrdersCreatedResponse(){
        CreateOrderResponse CreateOrderResponse1 =  CreateOrderResponse.builder()
                .amount(BigDecimal.valueOf(6500))
                .customerEmail("testUser@example.com")
                .orderedDate(LocalDateTime.now())
                .orderUpdatedDate(LocalDateTime.now())
                .orderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160")
                .build();
        CreateOrderResponse CreateOrderResponse2 =  CreateOrderResponse.builder()
                .amount(BigDecimal.valueOf(7500))
                .customerEmail("User@example.com")
                .orderedDate(LocalDateTime.now())
                .orderUpdatedDate(LocalDateTime.now())
                .orderId("0af866ef-838b-45fd-99f7-8584fe76afab")
                .build();
        List<CreateOrderResponse> resList = new ArrayList<>();
        resList.add(CreateOrderResponse1);
        resList.add(CreateOrderResponse2);

        return resList;
    }

    public static CreateOrderResponse getCreateOrderResponse(){
        return CreateOrderResponse.builder()
                .code("200")
                .status("SUCCESS")
                .message("Order created successfully")
                .orderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160")
                .build();
    }

    public static CreateOrderResponse getUpdateOrderResponse(){
        return CreateOrderResponse.builder()
                .code("200")
                .status("SUCCESS")
                .message("Order details updated successfully")
                .orderId("0af866ef-838b-45fd-99f7-8584fe76afab")
                .build();
    }

    public static CreateOrderResponse getCreateOrderErrorResponse(){
        return CreateOrderResponse.builder()
                .code("500")
                .status("FAILURE")
                .message("Exception occurred while creating the Order")
                .build();
    }

    public static OrderServiceTransactionEntity getOrderServiceTransactionEntityData() {
        OrderServiceTransactionEntity entity = new OrderServiceTransactionEntity();
        entity.setOrderedAmt(BigDecimal.valueOf(6500));
        entity.setCustomerEmail("testUser@example.com");
        entity.setOrderedDate(LocalDateTime.now());
        entity.setOrderUpdatedDate(LocalDateTime.now());
        entity.setOrderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160");
        return entity;
    }

    public static List<OrderServiceTransactionEntity> getOrderServiceTransactionEntityDataList(){
        OrderServiceTransactionEntity entity = new OrderServiceTransactionEntity();
        entity.setOrderedAmt(BigDecimal.valueOf(6500));
        entity.setCustomerEmail("testUser@example.com");
        entity.setOrderedDate(LocalDateTime.now());
        entity.setOrderUpdatedDate(LocalDateTime.now());
        entity.setOrderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160");

        OrderServiceTransactionEntity entity1 = new OrderServiceTransactionEntity();
        entity.setOrderedAmt(BigDecimal.valueOf(6500));
        entity.setCustomerEmail("testUser@example.com");
        entity.setOrderedDate(LocalDateTime.now());
        entity.setOrderUpdatedDate(LocalDateTime.now());
        entity.setOrderId("cc67593d-bf75-4c7d-90eb-6c56eeae1160");

        List<OrderServiceTransactionEntity> resList = new ArrayList<>();
        resList.add(entity);
        resList.add(entity1);

        return resList;
    }
}