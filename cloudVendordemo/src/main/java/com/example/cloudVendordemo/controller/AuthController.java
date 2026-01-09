package com.example.cloudVendordemo.controller;

import com.example.cloudVendordemo.DTO.LoginRequest;
import com.example.cloudVendordemo.service.AuthenticationService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody LoginRequest request) {
        String token = authenticationService.authenticate(request);
        return Map.of("token", token);
    }
}
