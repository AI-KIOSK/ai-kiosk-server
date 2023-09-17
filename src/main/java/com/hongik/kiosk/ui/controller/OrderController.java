package com.hongik.kiosk.ui.controller;


import com.hongik.kiosk.application.service.customer.CustomerReadUseCase;
import com.hongik.kiosk.application.service.menu.MenuReadUseCase;
import com.hongik.kiosk.application.service.order.OrderOperationUseCase;
import com.hongik.kiosk.application.service.order.OrderReadUseCase;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.CustomerEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.OrderItemEntity;
import com.hongik.kiosk.ui.requestBody.OrderCreateRequest;
import com.hongik.kiosk.ui.view.ApiResponseView;
import com.hongik.kiosk.ui.view.OrderView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.hongik.kiosk.application.service.customer.CustomerReadUseCase.*;
import static com.hongik.kiosk.application.service.order.OrderOperationUseCase.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderOperationUseCase orderOperationUseCase;
    @PostMapping("")
    public ResponseEntity<ApiResponseView<OrderView>> save(@RequestBody OrderCreateRequest request) {


        List<OrderCreateRequest.Orders> orders = request.getOrders();
        OrderCreateCommand command = OrderCreateCommand.builder()
                .phoneNumber(request.getPhoneNumber())
                .orderItems(orders)
                .totalPrice(request.getTotalPrice())
                .orderType(request.getOrderType())
                .build();

        OrderReadUseCase.FindOrderResult result = orderOperationUseCase.createOrder(command);
        return ResponseEntity.ok(new ApiResponseView<>(new OrderView(result)));
    }
}
