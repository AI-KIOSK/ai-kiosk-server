package com.hongik.kiosk.ui.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hongik.kiosk.application.domain.customer.Gender;
import com.hongik.kiosk.application.service.customer.CustomerReadUseCase;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerView {


    private final String phoneNum;

    private final Gender gender;

    private final float points;

    public CustomerView(CustomerReadUseCase.FindCustomerResult result) {
        this.phoneNum = result.getPhoneNumber();
        this.gender = result.getGender();
        this.points = result.getPoints();
    }
}
