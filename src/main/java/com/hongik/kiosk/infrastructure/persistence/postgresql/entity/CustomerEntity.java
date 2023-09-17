package com.hongik.kiosk.infrastructure.persistence.postgresql.entity;

import com.hongik.kiosk.application.domain.customer.Customer;
import com.hongik.kiosk.application.domain.customer.Gender;
import com.hongik.kiosk.application.service.customer.CustomerOperationUseCase;
import com.hongik.kiosk.application.service.customer.CustomerReadUseCase;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import static com.hongik.kiosk.application.service.customer.CustomerOperationUseCase.*;
import static com.hongik.kiosk.application.service.customer.CustomerReadUseCase.*;
import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@ToString
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @Column(name ="phone_number")
    private String phoneNumber;

    @Enumerated(STRING)
    private Gender gender;

    @Nullable
    private float points;

    public CustomerEntity() {

    }


    public CustomerEntity(FindCustomerResult customer) {
        this.phoneNumber = customer.getPhoneNumber();
        this.gender = customer.getGender();
        this.points = customer.getPoints();
    }

    public CustomerEntity(String phoneNumber, Gender gender) {
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
}


