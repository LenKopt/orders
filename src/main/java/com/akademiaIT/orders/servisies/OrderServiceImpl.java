package com.akademiaIT.orders.servisies;

import com.akademiaIT.orders.model.domain.OrderEntity;
import com.akademiaIT.orders.model.dto.OrderRequestDto;
import com.akademiaIT.orders.model.mapper.OrderMapper;
import com.akademiaIT.orders.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private OrderMapper orderMapper;
    private ProductService productService;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, ProductService productService) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.productService = productService;
    }

    @Override
    @Transactional
    public void addOrder(OrderRequestDto orderRequestDto) {
        OrderEntity orderEntity = productService.findByName(orderRequestDto.getProductName())
                .map(product -> {
                    product.updateProductQuantity(orderRequestDto.getQuantityOrdered());
                    return orderMapper.toEntity(orderRequestDto);
                }).orElseThrow(() -> new OrderServiceException("Nie udało się zrealizować zamówienia z powodu braku na stanie"));

        orderRepository.save(orderEntity);

    }


}
