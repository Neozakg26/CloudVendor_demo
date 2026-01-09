package com.example.cloudVendordemo.DTO;

public record LoginRequest(
        String email,
        String password
) { }
