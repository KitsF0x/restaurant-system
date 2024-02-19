package io.github.kitsf0x.restaurant_system.controller;

import org.springframework.web.bind.annotation.RestController;

import io.github.kitsf0x.restaurant_system.model.Order;
import io.github.kitsf0x.restaurant_system.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }
}
