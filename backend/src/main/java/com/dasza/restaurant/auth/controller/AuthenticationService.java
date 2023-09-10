package com.dasza.restaurant.auth.controller;

import com.dasza.restaurant.auth.config.JwtService;
import com.dasza.restaurant.auth.user.Role;
import com.dasza.restaurant.auth.user.User;
import com.dasza.restaurant.auth.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
           var user = User
                   .builder()
                   .firstName(request.getFirstName())
                   .lastName(request.getLastName())
                   .email(request.getEmail())
                   .password(passwordEncoder.encode(request.getPassword()))
                   .role(Role.CUSTOMER)
                   .build();
           repository.save(user);

           var jwtToken = jwtService.generateToken(user);
           return AuthenticationResponse
                   .builder()
                   .token(jwtToken)
                   .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
