package com.restuarant.restaurant.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restuarant.restaurant.auth.models.ERole;
import com.restuarant.restaurant.auth.models.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
