package com.akademiaIT.orders.servisies;

public class OrderServiceException extends RuntimeException{
    public OrderServiceException(String message) {
        super(message);
    }
}
