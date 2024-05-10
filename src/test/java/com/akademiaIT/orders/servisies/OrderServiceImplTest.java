package com.akademiaIT.orders.servisies;

import com.akademiaIT.orders.model.domain.OrderEntity;
import com.akademiaIT.orders.model.dto.OrderRequestDto;
import com.akademiaIT.orders.model.dto.ProductRequestDto;
import com.akademiaIT.orders.repository.OrderRepository;
import com.akademiaIT.orders.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

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

    private ProductRequestDto prepareProductRequestDto() {
        return new ProductRequestDto(NAME_EXIST_PRODUCT, QUANTITY_EXIST_PRODUCT);
    }

    @Test
    void adding_order_successfully() {
        //given
        OrderRequestDto orderRequestDto = new OrderRequestDto(NAME_EXIST_PRODUCT, QUANTITY_EXIST_PRODUCT);
        ProductRequestDto productRequestDto = prepareProductRequestDto();
        productService.addProduct(productRequestDto);
        //when
        orderService.addOrder(orderRequestDto);
        List<OrderEntity> all = orderRepository.findAll();
        //then
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void adding_order_when_product_not_exist() {
        //given
        ProductRequestDto productRequestDto = prepareProductRequestDto();
        productService.addProduct(productRequestDto);
        OrderRequestDto orderRequestDto = new OrderRequestDto(NAME_NOT_EXIST_PRODUCT, QUANTITY_EXIST_PRODUCT);
        //when
        Executable e = () -> orderService.addOrder(orderRequestDto);
        //then
        assertThrows(OrderServiceException.class, e);
    }
}