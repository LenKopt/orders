package com.akademiaIT.orders.servisies;

import com.akademiaIT.orders.model.domain.ProductEntity;
import com.akademiaIT.orders.model.dto.OrderRequestDto;
import com.akademiaIT.orders.model.mapper.OrderMapper;
import com.akademiaIT.orders.repository.OrderRepository;
import com.akademiaIT.orders.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;
    private ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void addOrder(OrderRequestDto orderRequestDto) {
        ProductEntity product = getProductByName(orderRequestDto);
        Integer countOfProduct = getQuantityOfProduct(product, orderRequestDto.getQuantityOrdered());

        orderRepository.save(orderMapper.toEntity(orderRequestDto));
        product.decreaseQuantity(orderRequestDto.getQuantityOrdered());
    }

    private static Integer getQuantityOfProduct(ProductEntity product, Integer countToOrder) {
        Integer countOfProduct = product.getQuantity();
        if (countOfProduct < countToOrder) {
            throw new RuntimeException("Nie mamy takiej ilości tego produktu");
        }
        return countOfProduct;
    }

    private ProductEntity getProductByName(OrderRequestDto orderRequestDto) {
        ProductEntity product = productRepository.findByName(orderRequestDto.getProductName());
        if (product == null) {
            throw new RuntimeException("Nie mamy takiego produktu!");
        }
        return product;
    }
}
