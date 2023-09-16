package com.hongik.kiosk.infrastructure.persistence.postgresql.repository;


import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    Optional<CustomerEntity> getCustomerByPhoneNumber(String phoneNumber);
}
