package com.example.cloudVendordemo.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long customerId;

    @NotBlank
    @Column(name = "first_name")
    private String customerFirstName;

    @Email
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(name = "last_name")
    private String customerLastName;

    @Column(unique = true, nullable = false, name = "phone")
    private String customerPhone;

    @Column(nullable = false)
    private String password;
}
