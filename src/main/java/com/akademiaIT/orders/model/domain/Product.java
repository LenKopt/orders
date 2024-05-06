package com.akademiaIT.orders.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private Long productId;
    private String productName;
    private Integer quantity;

    public Product(String productName, Integer quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }
}
