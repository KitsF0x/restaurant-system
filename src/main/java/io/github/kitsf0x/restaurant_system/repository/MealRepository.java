package io.github.kitsf0x.restaurant_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.kitsf0x.restaurant_system.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Integer> {

}
