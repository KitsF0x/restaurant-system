package io.github.kitsf0x.restaurant_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.kitsf0x.restaurant_system.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
