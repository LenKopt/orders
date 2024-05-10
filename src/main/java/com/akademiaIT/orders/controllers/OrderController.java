package com.akademiaIT.orders.controllers;

import com.akademiaIT.orders.model.dto.OrderRequestDto;
import com.akademiaIT.orders.model.dto.OrderResponceDto;
import com.akademiaIT.orders.model.dto.ProductRequestDto;
import com.akademiaIT.orders.model.dto.ProductResponceDto;
import com.akademiaIT.orders.servisies.OrderService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders/order")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("addOrder")
    public String addOrder(@RequestBody OrderRequestDto orderRequestDto) {
        orderService.addOrder(orderRequestDto);
        return "adding order was succesfully!";
    }

    @GetMapping("getAllOrders")
    public List<OrderResponceDto> getAllOrders() {
        return orderService.getAllOrders();
    }
}
