package com.hongik.kiosk.application.domain.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Customer {
    private final Long id;
    private final String phoneNumber;
    private final Gender gender;
    private final float points;
}
