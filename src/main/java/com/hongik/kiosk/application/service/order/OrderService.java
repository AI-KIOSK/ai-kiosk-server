package com.hongik.kiosk.application.service.order;

import com.hongik.kiosk.exception.AiKioskException;
import com.hongik.kiosk.exception.MessageType;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.CustomerEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.MenuEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.OrderEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.OrderItemEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.repository.CustomerRepository;
import com.hongik.kiosk.infrastructure.persistence.postgresql.repository.MenuRepository;
import com.hongik.kiosk.infrastructure.persistence.postgresql.repository.OrderRepository;
import com.hongik.kiosk.ui.requestBody.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.hongik.kiosk.exception.MessageType.NOT_FOUND;
import static com.hongik.kiosk.ui.requestBody.OrderCreateRequest.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService implements OrderOperationUseCase {

    private final OrderRepository orderRepository;
    private final MenuRepository menuRepository;
    private final CustomerRepository customerRepository;

    @Override
    public OrderReadUseCase.FindOrderResult createOrder(OrderCreateCommand command) {

        Optional<CustomerEntity> customer = customerRepository.findById(command.getPhoneNumber());

        if (customer.isEmpty()) throw new AiKioskException(NOT_FOUND);

        OrderEntity newOrder = new OrderEntity(command.getTotalPrice(), command.getOrderType(), customer.get());

        // create order
        newOrder = orderRepository.save(newOrder);


        ArrayList<OrderItemEntity> orderItems = new ArrayList<>();

        for (Orders order :
                command.getOrderItems()) {
            Optional<MenuEntity> menu = menuRepository.findByName(order.getMenuName());
            if (menu.isEmpty()) {
                orderRepository.delete(newOrder);
                throw new AiKioskException(NOT_FOUND);
            }
            orderItems.add(new OrderItemEntity(order, menu.get(), newOrder));
        }

        newOrder.setOrderItems(orderItems);

        return OrderReadUseCase.FindOrderResult.findByOrder(orderRepository.save(newOrder));

    }
}
