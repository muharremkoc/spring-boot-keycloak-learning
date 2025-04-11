package com.spring.keycloak.controller;

import com.spring.keycloak.model.AuthRequest;
import com.spring.keycloak.model.AuthResponse;
import com.spring.keycloak.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }
}
