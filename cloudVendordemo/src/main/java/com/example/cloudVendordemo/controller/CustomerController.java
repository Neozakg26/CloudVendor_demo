package com.example.cloudVendordemo.controller;

import com.example.cloudVendordemo.DTO.CustomerRegister;
import com.example.cloudVendordemo.Repository.CustomerRepository;
import com.example.cloudVendordemo.entity.Customer;
import com.example.cloudVendordemo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public void register(@RequestBody CustomerRegister customerRegister) {
        customerService.register(customerRegister);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        customerRepository.deleteById(id);
    }
}
