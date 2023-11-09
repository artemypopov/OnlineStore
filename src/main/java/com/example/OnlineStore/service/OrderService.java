package com.example.OnlineStore.service;
import com.example.OnlineStore.model.Order;
import com.example.OnlineStore.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public Order createOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    public List<Order> getAllOrders() {
        List<Order> books = new ArrayList<>();
        orderRepository.findAll().forEach(books::add);
        return books;
    }
}
