package com.akademiaIT.orders.servisies;

import com.akademiaIT.orders.model.domain.OrderEntity;
import com.akademiaIT.orders.model.domain.ProductEntity;
import com.akademiaIT.orders.model.dto.OrderRequestDto;
import com.akademiaIT.orders.model.dto.OrderResponceDto;
import com.akademiaIT.orders.model.mapper.OrderMapper;
import com.akademiaIT.orders.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ProductService productService;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, ProductService productService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productService = productService;
    }

    @Override
    public List<OrderResponceDto> getAllOrders() {
        return orderRepository
                .findAll()
                .stream()
                .map(order -> orderMapper.fromEntity(order))
                .toList();
    }

    @Override
    @Transactional
    public void addOrder(OrderRequestDto orderRequestDto) {
        OrderEntity orderEntity = productService.findByName(orderRequestDto.getProductName())
                .map(product -> {
                    product.updateProductQuantity(orderRequestDto.getQuantityOrdered());
                    cleareProductWithQueantityZero(product);
                    return orderMapper.toEntity(orderRequestDto);
                }).orElseThrow(() -> new OrderServiceException("Nie udało się zrealizować zamówienia z powodu braku na stanie"));

        orderRepository.save(orderEntity);

    }

    private void cleareProductWithQueantityZero(ProductEntity product) {
        if (product.isQuantityEqualZero()) {
            productService.deleteProduct(product);
        }
    }


}
