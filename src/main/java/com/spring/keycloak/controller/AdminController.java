package com.spring.keycloak.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping("/dashboard")
    public String getDashboard() {
        return "Admin Dashboard";
    }
}
