package com.example.cloudVendordemo.service;

import com.example.cloudVendordemo.Repository.CustomerRepository;
import com.example.cloudVendordemo.DTO.LoginRequest;
import com.example.cloudVendordemo.entity.Customer;
import com.example.cloudVendordemo.security.JwtService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static final String DUMMY_HASH = "token";

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;


    public AuthenticationService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String authenticate(LoginRequest request) {
        Customer customer = customerRepository.findByEmail(request.email()).orElse(null);

        String passwordHash = (customer != null) ? customer.getPassword() : DUMMY_HASH;

        boolean passwordMatch = passwordEncoder.matches(passwordHash, request.password());

        if (!passwordMatch || customer == null) {
            throw new BadCredentialsException("Invalid credentials");
        }

        return jwtService.generateToken(customer.getEmail());
    }

}
