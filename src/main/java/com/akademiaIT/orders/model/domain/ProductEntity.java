package com.akademiaIT.orders.model.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer quantity;

    public ProductEntity(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
