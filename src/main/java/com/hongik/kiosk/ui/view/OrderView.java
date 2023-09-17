package com.hongik.kiosk.ui.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hongik.kiosk.application.service.order.OrderReadUseCase;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.CustomerEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.OrderItemEntity;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderView {

    private final Long id;
    private final int totalPrice;
    private final String orderType;

    private final CustomerEntity customer;


    public OrderView(OrderReadUseCase.FindOrderResult result) {
        this.id = result.getId();
        this.totalPrice = result.getTotalPrice();
        this.orderType = result.getOrderType();

        this.customer = result.getCustomer();

    }

}
