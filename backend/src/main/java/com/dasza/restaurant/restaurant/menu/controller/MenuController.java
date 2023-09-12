package com.dasza.restaurant.restaurant.menu.controller;

import com.dasza.restaurant.restaurant.menu.Menu;
import com.dasza.restaurant.restaurant.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/restaurant/menus")
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/getListOfMenus")
    public ResponseEntity<Page<Menu>> getMenus(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "limit", defaultValue = "25") int limit) {
        // Call the service method to get paginated menus
        return ResponseEntity.ok(menuService.listMenu(page, limit));
    }
}
