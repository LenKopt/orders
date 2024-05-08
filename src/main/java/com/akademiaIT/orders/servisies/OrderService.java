package com.akademiaIT.orders.servisies;

import com.akademiaIT.orders.model.dto.OrderRequestDto;

public interface OrderService {
    void addOrder(OrderRequestDto orderRequestDto);
}
