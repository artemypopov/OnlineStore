package com.example.OnlineStore.controller;

import com.example.OnlineStore.model.product.Product;
import com.example.OnlineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/search/{name}")
    public List<Product> search(@PathVariable String name) {
        return productService.search(name);
    }

    @GetMapping("/cat/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return productService.getProductsByCategory(category);
    }

    @PostMapping(value = "/add")
    public Product addProduct(@RequestBody Product product) {
         productService.addProduct(product);
        return product;
    }
}
