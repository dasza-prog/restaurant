package com.dasza.restaurant.restaurant.menu;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.user.id = :userId")
    List<Order> customerOrderList(@Param("userId") Integer userId);
    void deleteById(@NonNull Integer orderId);
}
