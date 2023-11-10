package com.example.OnlineStore.controller;

import com.example.OnlineStore.model.Product;
import com.example.OnlineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/cat/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @PostMapping(value = "/add")
    public Product save(@RequestBody Product product) {
         productService.addProduct(product);
        return product;
    }
}
