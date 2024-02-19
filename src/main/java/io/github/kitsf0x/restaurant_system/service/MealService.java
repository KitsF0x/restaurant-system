package io.github.kitsf0x.restaurant_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.kitsf0x.restaurant_system.exception.MealNotFoundException;
import io.github.kitsf0x.restaurant_system.model.Meal;
import io.github.kitsf0x.restaurant_system.repository.MealRepository;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public Meal createMeal(Meal meal) {
        if (meal == null) {
            throw new MealNotFoundException();
        }
        return mealRepository.save(meal);
    }
}
