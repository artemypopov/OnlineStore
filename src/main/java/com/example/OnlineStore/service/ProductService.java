package com.example.OnlineStore.service;

import com.example.OnlineStore.model.product.Product;
import com.example.OnlineStore.model.product.ProductCategory;
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
        return new ArrayList<>(productRepository.findByCategory(ProductCategory.valueOf(category)));
    }

    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public List<Product> search(String name) {
        return new ArrayList<>(productRepository.findByNameContaining(name));
    }
}
