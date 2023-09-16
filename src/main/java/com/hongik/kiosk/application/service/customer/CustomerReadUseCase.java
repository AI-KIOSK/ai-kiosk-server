package com.hongik.kiosk.application.service.customer;

import com.hongik.kiosk.application.domain.customer.Gender;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.CustomerEntity;
import lombok.*;

public interface CustomerReadUseCase {

    FindCustomerResult getUser(CustomerFindQuery query);

    @NoArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Getter
    @ToString
    class CustomerFindQuery {
        private String phoneNumber;

        public CustomerFindQuery(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }

    @Getter
    @Builder
    @ToString
    class FindCustomerResult {
        private final String phoneNumber;
        private final Gender gender;
        private final float points;

        public static FindCustomerResult findByCustomer(CustomerEntity customer) {
            return FindCustomerResult.builder()
                    .phoneNumber(customer.getPhoneNumber())
                    .gender(customer.getGender())
                    .points(customer.getPoints())
                    .build();
        }
    }
}
