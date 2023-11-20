package com.hongik.kiosk.application.service.menu;

import com.hongik.kiosk.infrastructure.persistence.postgresql.entity.MenuEntity;
import com.hongik.kiosk.infrastructure.persistence.postgresql.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class MenuService implements MenuReadUseCase {

    private final MenuRepository menuRepository;

    @Override
    public List<FindMenuResult> findAllMenu() {
        return menuRepository.findAll().stream().map(FindMenuResult::findByMenu).collect(Collectors.toList());
    }

    @Override
    public FindMenuResult findMenuByName(String name) {
        Optional<MenuEntity> result = menuRepository.findByName(name);
        return result.map(FindMenuResult::findByMenu).orElse(null);

    }
}
