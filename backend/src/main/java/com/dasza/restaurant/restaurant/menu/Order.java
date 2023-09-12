package com.dasza.restaurant.restaurant.menu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Integer id;

    private Float totalPrice;

    // Define the many-to-many relationship with Menu
    @ManyToMany
    @JoinTable(
            name = "order_menu",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "menu_id")
    )
    private List<Menu> menus;
}
