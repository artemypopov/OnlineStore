package com.example.OnlineStore.controller;

import com.example.OnlineStore.model.Order;
import com.example.OnlineStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping(value = "create/order")
    @ResponseBody
    public Order save(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
}
