package com.akademiaIT.orders.servisies;

import com.akademiaIT.orders.model.dto.OrderRequestDto;
import com.akademiaIT.orders.model.dto.ProductRequestDto;
import com.akademiaIT.orders.model.dto.ProductResponceDto;
import com.akademiaIT.orders.repository.OrderRepository;
import com.akademiaIT.orders.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class OrderServiceImplTest {
    public final String NAME_EXIST_PRODUCT = "coffee";
    public final String NAME_NOT_EXIST_PRODUCT = "tea";
    public final Integer QUANTITY_EXIST_PRODUCT = 100;
    public final Integer QUANTITY_ORDERED_LESS = 90;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @AfterEach
    void tearDown() {
        orderRepository.deleteAll();
        productRepository.deleteAll();
    }

    private void addAtLeastOneProduct() {
        ProductRequestDto productRequestDto = new ProductRequestDto(NAME_EXIST_PRODUCT, QUANTITY_EXIST_PRODUCT);
        productService.addProduct(productRequestDto);
    }

    @Test
    void adding_order_successfully() {
        //given
        OrderRequestDto orderRequestDto = new OrderRequestDto(NAME_EXIST_PRODUCT, QUANTITY_EXIST_PRODUCT);
        addAtLeastOneProduct();
        //when
        orderService.addOrder(orderRequestDto);
        //then
        assertThat(orderRepository.findAll().stream().toList().size()).isEqualTo(1);
    }

    @Test
    void adding_order_when_product_not_exist() {
        //given
        addAtLeastOneProduct();
        OrderRequestDto orderRequestDto = new OrderRequestDto(NAME_NOT_EXIST_PRODUCT, QUANTITY_EXIST_PRODUCT);
        //when
        Executable e = () -> orderService.addOrder(orderRequestDto);
        //then
        assertThrows(OrderServiceException.class, e);
    }
}