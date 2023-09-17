package com.hongik.kiosk.infrastructure.persistence.postgresql.entity;


import com.hongik.kiosk.application.domain.menu.HotOrIced;
import com.hongik.kiosk.ui.requestBody.OrderCreateRequest;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Getter
@ToString
@Entity
@Table(name = "order_item")
public class OrderItemEntity {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "order_quantity")
    private int orderQuantity;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "menu_id")
    private MenuEntity menu;

    private String hotOrIced;

    private String sweetness;

    private int pump;

    @Column(name = "ice_amount")
    private String iceAmount;

    @Column(name = "whipping_amount")
    private String whippingAmount;

    private int shots;

    private int whippings;


    public OrderItemEntity(OrderCreateRequest.Orders orders, MenuEntity menu, OrderEntity order) {
        this.id = orders.getId();
        this.order = order;
        this.menu = menu;
        this.menuName = orders.getMenuName();
        this.orderQuantity = orders.getOrderQuantity();
        this.hotOrIced = orders.getHotOrIced();
        this.sweetness = orders.getSweetness();
        this.pump = orders.getPump();
        this.iceAmount = orders.getIceAmount();
        this.whippingAmount = orders.getWhippingAmount();
        this.shots = orders.getShots();
        this.whippings = orders.getWhippings();
    }

    public OrderItemEntity() {

    }
}
