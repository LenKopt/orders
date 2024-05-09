package com.akademiaIT.orders.servisies;

import com.akademiaIT.orders.model.domain.ProductEntity;
import com.akademiaIT.orders.model.dto.ProductRequestDto;
import com.akademiaIT.orders.model.dto.ProductResponceDto;
import com.akademiaIT.orders.model.mapper.ProductMapper;
import com.akademiaIT.orders.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ProductResponceDto> getAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(product -> productMapper.fromEntity(product))
                .toList();
    }

    @Override
    public Optional<ProductEntity> findByName(String name) {
        return productRepository.findByName(name);
    }
}
