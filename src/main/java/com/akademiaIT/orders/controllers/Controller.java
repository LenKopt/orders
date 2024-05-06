package com.akademiaIT.orders.controllers;

import com.akademiaIT.orders.model.dto.ProductRequestDto;
import com.akademiaIT.orders.servisies.ProductService;
import com.akademiaIT.orders.servisies.ProductServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/orders")
public class Controller {
    private ProductService productService;

    public Controller(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("addProduct")
    public String addDoctor(@RequestBody ProductRequestDto productRequestDto) {
        productService.addProduct(productRequestDto);
        return "add product was added succesfully!";
    }
}
