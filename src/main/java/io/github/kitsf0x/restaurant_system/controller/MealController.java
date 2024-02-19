package io.github.kitsf0x.restaurant_system.controller;

import org.springframework.web.bind.annotation.RestController;

import io.github.kitsf0x.restaurant_system.model.Meal;
import io.github.kitsf0x.restaurant_system.service.MealService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MealController {

    @Autowired
    MealService mealService;

    @PostMapping("/meals")
    public ResponseEntity<Meal> createMeal(@RequestBody Meal meal) {
        return ResponseEntity.ok(mealService.createMeal(meal));
    }
}
