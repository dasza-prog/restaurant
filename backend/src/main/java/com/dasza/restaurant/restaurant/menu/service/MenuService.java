package com.dasza.restaurant.restaurant.menu.service;

import com.dasza.restaurant.restaurant.menu.Menu;
import com.dasza.restaurant.restaurant.menu.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository repository;


    public Page<Menu> listMenu(Integer page, Integer limit){
        Pageable pageable = PageRequest.of(page - 1, limit);

        return repository.findAll(pageable);
    }
}
