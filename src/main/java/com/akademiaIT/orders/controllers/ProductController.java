package com.akademiaIT.orders.controllers;

import com.akademiaIT.orders.model.dto.ProductRequestDto;
import com.akademiaIT.orders.model.dto.ProductResponceDto;
import com.akademiaIT.orders.servisies.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("addProduct")
    public String addDoctor(@RequestBody ProductRequestDto productRequestDto) {
        productService.addProduct(productRequestDto);
        return "add product was added succesfully!";
    }
    @GetMapping("getAllProducts")
    public List<ProductResponceDto> getAllDoctors() {
        return productService.getAllProducts();
    }
}
