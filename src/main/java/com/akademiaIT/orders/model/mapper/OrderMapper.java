package com.akademiaIT.orders.model.mapper;

import com.akademiaIT.orders.model.domain.OrderEntity;
import com.akademiaIT.orders.model.domain.ProductEntity;
import com.akademiaIT.orders.model.dto.OrderRequestDto;
import com.akademiaIT.orders.model.dto.OrderResponceDto;
import com.akademiaIT.orders.model.dto.ProductRequestDto;
import com.akademiaIT.orders.model.dto.ProductResponceDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderEntity toEntity(OrderRequestDto orderRequestDto) {
        return new OrderEntity(orderRequestDto.getProductName(), orderRequestDto.getQuantityOrdered());
    }

    public OrderResponceDto fromEntity(OrderEntity orderEntity) {
        return new OrderResponceDto(orderEntity.getId(), orderEntity.getProductName(), orderEntity.getQuantityOrdered());
    }
}
