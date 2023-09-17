package com.hongik.kiosk.infrastructure.persistence.postgresql.entity;


import com.hongik.kiosk.application.service.order.OrderOperationUseCase;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.hongik.kiosk.application.service.order.OrderOperationUseCase.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "phone_number")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItemEntity> orderItems = new ArrayList<>();

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "order_type")
    private String orderType;

    public OrderEntity(int totalPrice, String orderType, CustomerEntity customer) {
        this.totalPrice = totalPrice;
        this.orderType = orderType;
        this.customer = customer;
    }

    public OrderEntity() {
    }
}
