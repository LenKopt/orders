package com.akademiaIT.orders.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private Integer quantityOrdered;

    public OrderEntity(String productName, Integer quantityOrdered) {
        this.productName = productName;
        this.quantityOrdered = quantityOrdered;
    }
}
