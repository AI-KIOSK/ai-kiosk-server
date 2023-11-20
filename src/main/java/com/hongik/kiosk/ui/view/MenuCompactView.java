package com.hongik.kiosk.ui.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hongik.kiosk.application.service.menu.MenuReadUseCase;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.CategoryEntity;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuCompactView {
    private final Long id;
    private final String name;
    private final String category;

    private final int price;
    private final String iceImgUrl;
    private final String hotImgUrl;

    public MenuCompactView(MenuReadUseCase.FindMenuResult result) {
        this.id = result.getId();
        this.name = result.getName();
        this.price = result.getPrice();
        this.category = result.getCategory().getCategory();
        this.iceImgUrl = result.getIce_img_url();
        this.hotImgUrl = result.getHot_img_url();
    }
}
