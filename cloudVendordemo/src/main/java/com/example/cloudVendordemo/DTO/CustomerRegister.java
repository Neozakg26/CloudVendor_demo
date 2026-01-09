package com.example.cloudVendordemo.DTO;

public record CustomerRegister(
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber
        ){}

