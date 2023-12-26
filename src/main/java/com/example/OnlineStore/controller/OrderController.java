package com.example.OnlineStore.controller;

import com.example.OnlineStore.model.order.Order;
import com.example.OnlineStore.model.order.OrderRequestDTO;
import com.example.OnlineStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public Order save(@RequestBody OrderRequestDTO dto) {
        try {
            return orderService.createOrder(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping(value = "/get/{id}")
    @ResponseBody
    public List<Order> getOrdersByUserId(@PathVariable Long id) {
        try {
            return orderService.getOrdersByUserId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping(value = "/current")
    @ResponseBody
    public List<Order> getOrdersByCurrentUser() {
        try {
            return orderService.getOrdersByCurrentUser();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
