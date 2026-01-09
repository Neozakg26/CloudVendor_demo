package com.example.cloudVendordemo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String orderId;
    private String customerId;
    private String OrderItems;
    private String orderDate;
    private Basket orderBasket;
}
