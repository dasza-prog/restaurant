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
@Table(name="_restaurant")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // Define the many-to-many relationship with Order
    @ManyToMany(mappedBy = "menus")
    private List<Order> orders;

    private String menuName;
    private Float menuPrice;
    private String menuDescription;
    private Boolean menuAvailability;
}
