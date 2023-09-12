package com.dasza.restaurant.restaurant.menu.controller;

import com.dasza.restaurant.restaurant.menu.Order;
import com.dasza.restaurant.restaurant.menu.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurant/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/listOfCustomerOrders")
    public ResponseEntity<List<Order>> customerOrders (@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.replace("Bearer ", "");
        return ResponseEntity.ok(orderService.getOrdersByUserId(token));
    }
}
