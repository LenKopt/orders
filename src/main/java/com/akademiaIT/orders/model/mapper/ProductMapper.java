package com.akademiaIT.orders.model.mapper;

import com.akademiaIT.orders.model.domain.Product;
import com.akademiaIT.orders.model.dto.ProductRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequestDto productRequestDto) {
        return new Product(productRequestDto.getProductName(), productRequestDto.getQuantity());
    }
}
