package com.dasza.restaurant.restaurant.menu.service;

import com.dasza.restaurant.auth.config.JwtService;
import com.dasza.restaurant.auth.user.User;
import com.dasza.restaurant.auth.user.UserRepository;
import com.dasza.restaurant.restaurant.menu.Order;
import com.dasza.restaurant.restaurant.menu.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final JwtService jwt;
    private final UserRepository userRepository;


    public List<Order> getOrdersByUserId(String token) {
        String email = jwt.extractUsername(token);

        var user = userRepository.findByEmail(email)
                .orElseThrow();
        return repository.customerOrderList(user.getId());
    }
}
