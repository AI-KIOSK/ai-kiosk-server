package com.hongik.kiosk.application.service.customer;

import com.hongik.kiosk.application.domain.customer.Customer;
import com.hongik.kiosk.exception.AiKioskException;
import com.hongik.kiosk.exception.MessageType;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.CustomerEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.hongik.kiosk.exception.MessageType.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService implements CustomerReadUseCase, CustomerOperationUseCase{

    private final CustomerRepository customerRepository;

    @Override
    public FindCustomerResult createCustomer(CustomerCreateCommand command) {

        log.info("create command = {}",command.getPhoneNumber());
        CustomerEntity result = customerRepository.save(new CustomerEntity(command.getPhoneNumber(), command.getGender()));
        return FindCustomerResult.findByCustomer(result);
    }

    @Override
    public FindCustomerResult getUser(CustomerFindQuery query){

        String phoneNumber = query.getPhoneNumber();
        Optional<CustomerEntity> result = customerRepository.findById(phoneNumber);

        return result.map(FindCustomerResult::findByCustomer).orElseThrow(() -> new AiKioskException(NOT_FOUND));
    }

}
