package com.example.cloudVendordemo.service;

import com.example.cloudVendordemo.DTO.CustomerRegister;
import com.example.cloudVendordemo.Repository.CustomerRepository;
import com.example.cloudVendordemo.entity.Customer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(CustomerRegister customerRegister) {
        if (customerRepository.existsByEmail(customerRegister.email())){
            return;
        }

        Customer customer = new Customer();
        customer.setCustomerFirstName(customerRegister.firstName());
        customer.setCustomerLastName(customerRegister.lastName());
        customer.setEmail(customerRegister.email());
        customer.setCustomerPhone(customerRegister.phoneNumber());
        customer.setPassword(customerRegister.password());
        customer.setPassword(
                passwordEncoder.encode(customerRegister.password())
        );
        customerRepository.save(customer);

    }
}
