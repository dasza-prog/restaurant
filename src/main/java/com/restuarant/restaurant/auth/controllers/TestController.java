package com.restuarant.restaurant.auth.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/customer")
  @PreAuthorize("hasRole('CUSTOMER') or hasRole('STAFF') or hasRole('OWNER')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/staff")
  @PreAuthorize("hasRole('STAFF')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/OWNER")
  @PreAuthorize("hasRole('OWNER')")
  public String adminAccess() {
    return "Admin Board.";
  }
}