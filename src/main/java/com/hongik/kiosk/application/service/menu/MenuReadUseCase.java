package com.hongik.kiosk.application.service.menu;

import com.hongik.kiosk.application.domain.menu.HotOrIced;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.CategoryEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.MenuEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

public interface MenuReadUseCase {

    List<FindMenuResult> findAllMenu();

    @Getter
    @Builder
    @ToString
    class FindMenuResult {

        private final Long id;
        private final String name;
        private final int price;
        private final HotOrIced hotOrIced;
        private final boolean isWhipping;
        private final CategoryEntity category;

        public static FindMenuResult findByMenu(MenuEntity menu) {
            return FindMenuResult.builder()
                    .id(menu.getId())
                    .name(menu.getName())
                    .price(menu.getPrice())
                    .hotOrIced(menu.getHotOrIced())
                    .isWhipping(menu.isWhipping())
                    .category(menu.getCategory())
                    .build();
        }
    }
}
