package com.hongik.kiosk.ui.requestBody;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderCreateRequest {
    private String phoneNumber;
    private int totalPrice;
    private String orderType;
    private List<Orders> orders = new ArrayList<>();

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    public static class Orders {
        private Long id;
        private String menuName;
        private String hotOrIced;
        private int orderQuantity;
        private String sweetness;
        private int pump;
        private String iceAmount;
        private String whippingAmount;
        private int shots;
        private int whippings;
    }

}
