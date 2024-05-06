package com.akademiaIT.orders.servisies;

import com.akademiaIT.orders.model.dto.ProductRequestDto;
import com.akademiaIT.orders.model.mapper.ProductMapper;
import com.akademiaIT.orders.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public void addProduct(ProductRequestDto productRequestDto) {
        productRepository.save(productMapper.toEntity(productRequestDto));
    }
}
