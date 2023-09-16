package com.hongik.kiosk.infrastructure.persistence.postgresql.entity;


import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@ToString
@Entity
public class OptionEntity {

    @Id
    @GeneratedValue
    @Column(name = "option_id")
    private Long id;

    @Column(name = "option_type")
    private String type;

    @Column(name = "option_name")
    private String name;
}
