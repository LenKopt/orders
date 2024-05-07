package com.akademiaIT.orders.controllers;

import com.akademiaIT.orders.model.dto.ProductRequestDto;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders/order")
public class OrderController {
    private OrderService orderService;
    @PostMapping("addOrder")
    public String addOrder(@RequestBody OrderRequestDto orderRequestDto) {
        productService.addProduct(orderRequestDto);
        return "adding order was succesfully!";
    }
}
