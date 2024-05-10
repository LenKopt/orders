package com.akademiaIT.orders.controllers;

import com.akademiaIT.orders.servisies.OrderServiceException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderControllerAdvice {
    @ExceptionHandler({OrderServiceException.class})
    public ResponseEntity<ErrorResponse> handleOrderServiceException(Exception ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(ex.getMessage()));
    }

    @Getter
    @AllArgsConstructor
    class ErrorResponse {
        private String reason;
    }
}




