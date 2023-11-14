package com.hongik.kiosk.infrastructure.persistence.postgresql.entity;


import com.hongik.kiosk.application.domain.menu.HotOrIced;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.awt.*;
import java.nio.ByteBuffer;


@Getter
@ToString
@Entity
@Table(name = "menu")
public class MenuEntity {

    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private Long id;

    private String name;

    @Column(name ="name_eng")
    private String nameEng;

    private int price;

    @Enumerated(EnumType.STRING)
    private HotOrIced hotOrIced;

    private boolean isWhipping;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    private String description;

    @Column(name = "ice_img_url")
    private String iceImgUrl;
    @Column(name = "hot_img_url")
    private String hotImgUrl;
}
