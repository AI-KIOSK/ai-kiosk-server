package com.hongik.kiosk.application.service.order;

import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.CustomerEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.OrderEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.OrderItemEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public interface OrderReadUseCase {


    @Getter
    @Builder
    @ToString
    class FindOrderResult {
        private final Long id;
        private final int totalPrice;
        private final String orderType;
        private final CustomerEntity customer;

        private List<OrderItemEntity> orderItems;




        public static FindOrderResult findByOrder(OrderEntity order){
            return FindOrderResult.builder()
                    .id(order.getId())
                    .customer(order.getCustomer())
                    .orderItems(order.getOrderItems())
                    .totalPrice(order.getTotalPrice())
                    .orderType(order.getOrderType())
                    .build();
        }
    }
}
