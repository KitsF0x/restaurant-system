package io.github.kitsf0x.restaurant_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.kitsf0x.restaurant_system.exception.OrderNotFoundException;
import io.github.kitsf0x.restaurant_system.model.Order;
import io.github.kitsf0x.restaurant_system.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        if (order == null) {
            throw new OrderNotFoundException();
        }
        return orderRepository.save(order);
    }
}
