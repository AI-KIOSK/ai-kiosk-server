package com.hongik.kiosk.application.service.customer;

import com.hongik.kiosk.application.domain.customer.Gender;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.hongik.kiosk.application.service.customer.CustomerOperationUseCase.CustomerCreateCommand.builder;
import static com.hongik.kiosk.application.service.customer.CustomerReadUseCase.*;
import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerOperationUseCase customerOperationUseCase;
    @Autowired
    private CustomerReadUseCase customerReadUseCase;

    @BeforeEach
    void init() {
//        CustomerOperationUseCase.CustomerCreateCommand memberA = builder()
//                .phoneNumber("47654722")
//                .gender("MALE")
//                .build();
//        FindCustomerResult customer = customerOperationUseCase.createCustomer(memberA);
    }

    @Test
    void createCustomer() {

        CustomerOperationUseCase.CustomerCreateCommand memberA = builder()
                .phoneNumber("47654722")
                .gender(Gender.MALE)
                .build();

        FindCustomerResult customer = customerOperationUseCase.createCustomer(memberA);
        FindCustomerResult customer2 = customerOperationUseCase.createCustomer(memberA);

        log.info(customer.toString());

    }

    @Test
    void getUser() {

        CustomerFindQuery _200Query = new CustomerFindQuery("47654722");
        CustomerFindQuery _404Query = new CustomerFindQuery("111111111");

        log.info("200 query = {}",_200Query.getPhoneNumber());
        log.info("404 query = {}",_404Query.getPhoneNumber());

        FindCustomerResult _200Result = customerReadUseCase.getUser(_200Query);
        log.info(_200Result.toString());

    }
}