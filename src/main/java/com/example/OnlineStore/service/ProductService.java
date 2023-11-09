package com.example.OnlineStore.service;

import com.example.OnlineStore.model.Product;
import com.example.OnlineStore.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getProductsByCategory(String category) {
        List<Product> products = new ArrayList<>();
        products.addAll(productRepository.findByCategory(category));
        return products;
    }

    public Product createProduct(Product product) {
        productRepository.save(product);
        return product;
    }
}
