package com.hongik.kiosk.ui.controller;


import com.hongik.kiosk.application.service.menu.MenuReadUseCase;
import com.hongik.kiosk.ui.view.ApiResponseView;
import com.hongik.kiosk.ui.view.MenuView;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MenuController {

    private final MenuReadUseCase menuReadUseCase;

    @GetMapping("/menus")
    public ResponseEntity<ApiResponseView<List<MenuView>>> getAllMenu() {

        List<MenuReadUseCase.FindMenuResult> results = menuReadUseCase.findAllMenu();

        return ResponseEntity.ok(new ApiResponseView<>(results.stream().map(MenuView::new).collect(Collectors.toList())));

    }
}
