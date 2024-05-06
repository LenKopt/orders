package com.akademiaIT.orders.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {
    @Id
    private Long orderId;
    private String orderName;
}
