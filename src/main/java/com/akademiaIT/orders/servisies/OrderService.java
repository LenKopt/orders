package com.akademiaIT.orders.servisies;

import com.akademiaIT.orders.model.dto.OrderRequestDto;
import com.akademiaIT.orders.model.dto.OrderResponceDto;

import java.util.List;

public interface OrderService {
    public void addOrder(OrderRequestDto orderRequestDto);
    public List<OrderResponceDto> getAllOrders();
}
