package com.hongik.kiosk.ui.requestBody;

import com.hongik.kiosk.application.domain.customer.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CustomerCreateRequest {
    private String phoneNumber;
    private Gender gender;
}
