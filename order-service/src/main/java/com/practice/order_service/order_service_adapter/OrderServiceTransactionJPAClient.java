package com.practice.order_service.order_service_adapter;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface OrderServiceTransactionJPAClient extends JpaRepository<OrderServiceTransactionEntity,String> {

    @Transactional
    OrderServiceTransactionEntity findByCustomerEmail(String emailId);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = """
       UPDATE ORDER_ENTRY SET ORDERED_AMT = :orderedAmt,ORDER_UPDATED_DATE = :orderUpdatedDate WHERE CUSTOMER_EMAIL = :customerEmail""", nativeQuery = true
    )
    Integer updateOrder(
            @Param("orderedAmt") BigDecimal orderedAmt,
            @Param("orderUpdatedDate") LocalDateTime orderUpdatedDate,
            @Param("customerEmail") String customerEmail
    );
}