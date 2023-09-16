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
    private final int price;
    private final HotOrIced hotOrIced;
    private boolean isWhipping;
    private final CategoryEntity category;

    public MenuView(MenuReadUseCase.FindMenuResult result) {
        this.id = result.getId();
        this.name = result.getName();
        this.price = result.getPrice();
        this.hotOrIced = result.getHotOrIced();
        this.category = result.getCategory();
    }
}
