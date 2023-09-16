package com.hongik.kiosk.infrastructure.persistence.postgresql.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String category;

}
