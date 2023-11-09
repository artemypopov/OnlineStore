package com.example.OnlineStore.controller;

import com.example.OnlineStore.model.Product;
import com.example.OnlineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@Controller
@ResponseBody
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @PostMapping(value = "create/product")
    @ResponseBody
    public Product save(@RequestBody Product product) {
        return productService.createProduct(product);
    }

}
