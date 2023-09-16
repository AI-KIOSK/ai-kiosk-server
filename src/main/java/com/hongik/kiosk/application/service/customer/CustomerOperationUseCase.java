package com.hongik.kiosk.application.service.customer;

import com.hongik.kiosk.application.domain.customer.Gender;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import static com.hongik.kiosk.application.service.customer.CustomerReadUseCase.*;

public interface CustomerOperationUseCase {

    FindCustomerResult createCustomer(CustomerCreateCommand command);

    @EqualsAndHashCode
    @Getter
    @Builder
    @ToString
    class CustomerCreateCommand {
        private final String phoneNumber;
        private final Gender gender;
    }


}
