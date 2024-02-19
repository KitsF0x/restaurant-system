package io.github.kitsf0x.restaurant_system.controller;

import org.springframework.web.bind.annotation.RestController;

import io.github.kitsf0x.restaurant_system.exception.OrderNotFoundException;
import io.github.kitsf0x.restaurant_system.model.Order;
import io.github.kitsf0x.restaurant_system.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        try {
            Order order = orderService.getById(id);
            return ResponseEntity.ok(order);
        } catch (OrderNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
