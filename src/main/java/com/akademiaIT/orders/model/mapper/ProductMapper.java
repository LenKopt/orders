package com.akademiaIT.orders.model.mapper;

import com.akademiaIT.orders.model.domain.ProductEntity;
import com.akademiaIT.orders.model.dto.ProductRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductEntity toEntity(ProductRequestDto productRequestDto) {
        return new ProductEntity(productRequestDto.getProductName(), productRequestDto.getQuantity());
    }
}
