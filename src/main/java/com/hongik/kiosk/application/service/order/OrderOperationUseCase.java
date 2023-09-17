package com.hongik.kiosk.application.service.order;

import com.hongik.kiosk.application.service.order.OrderReadUseCase.FindOrderResult;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.CustomerEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.MenuEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.OrderEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.OrderItemEntity;
import com.hongik.kiosk.ui.requestBody.OrderCreateRequest;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public interface OrderOperationUseCase {

    FindOrderResult createOrder(OrderCreateCommand command);


    @EqualsAndHashCode
    @Getter
    @Builder
    @ToString
    class OrderCreateCommand {
        // 주문 관련
        private final String orderType;
        private final int totalPrice;

        private final String phoneNumber;
        private final List<OrderCreateRequest.Orders> orderItems;
    }
}
