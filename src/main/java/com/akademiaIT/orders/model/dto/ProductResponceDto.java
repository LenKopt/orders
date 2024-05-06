package com.akademiaIT.orders.model.dto;

import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResponceDto {

    private Long productId;
    private String productName;
    private Integer quantity;
}
