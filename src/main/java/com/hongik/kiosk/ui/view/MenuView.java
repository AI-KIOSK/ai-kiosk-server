package com.hongik.kiosk.ui.view;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.hongik.kiosk.application.domain.menu.HotOrIced;
import com.hongik.kiosk.application.service.menu.MenuReadUseCase;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.CategoryEntity;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuView {

    private final Long id;
    private final String name;
    private final String nameEng;
    private final int price;
    private final HotOrIced hotOrIced;
    private final boolean isWhipping;
    private final CategoryEntity category;
    private final String description;
    private final String iceImgUrl;
    private final String hotImgUrl;

    public MenuView(MenuReadUseCase.FindMenuResult result) {
        this.id = result.getId();
        this.name = result.getName();
        this.nameEng = result.getNameEng();
        this.price = result.getPrice();
        this.isWhipping = result.isWhipping();
        this.hotOrIced = result.getHotOrIced();
        this.category = result.getCategory();
        this.description = result.getDescription();
        this.iceImgUrl = result.getIce_img_url();
        this.hotImgUrl = result.getHot_img_url();
    }
}
