package com.akademiaIT.orders.servisies;

import com.akademiaIT.orders.model.domain.ProductEntity;
import com.akademiaIT.orders.model.dto.ProductRequestDto;
import com.akademiaIT.orders.model.dto.ProductResponceDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public void addProduct(ProductRequestDto productRequestDto);
    public List<ProductResponceDto> getAllProducts();
    Optional<ProductEntity> findByName(String name);
}
