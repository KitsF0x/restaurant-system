package io.github.kitsf0x.restaurant_system.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.github.kitsf0x.restaurant_system.model.Meal;
import io.github.kitsf0x.restaurant_system.service.MealService;

@ExtendWith(MockitoExtension.class)
public class MealControllerTest {
    @Mock
    private MealService mealService;

    @InjectMocks
    private MealController mealController;

    @Test
    public void WhenCalled_CreateMeal_ShouldCallCreateMealMethodInService() {
        // Arrange
        Meal meal = new Meal();

        // Act
        mealController.createMeal(meal);

        // Assert
        verify(mealService, times(1)).createMeal(meal);
    }

}
