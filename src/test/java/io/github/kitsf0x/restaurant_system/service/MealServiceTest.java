package io.github.kitsf0x.restaurant_system.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.github.kitsf0x.restaurant_system.exception.MealNotFoundException;
import io.github.kitsf0x.restaurant_system.model.Meal;
import io.github.kitsf0x.restaurant_system.repository.MealRepository;

@ExtendWith(MockitoExtension.class)
public class MealServiceTest {
    @Mock
    private MealRepository mealRepository;

    @InjectMocks
    private MealService mealService;

    @SuppressWarnings("null")
    @Test
    public void WhenCalled_CreateMeal_ShouldCallSaveOrderInRepository() {
        // Arrange
        Meal meal = new Meal();
        when(mealRepository.save(meal)).thenReturn(meal);

        // Act
        mealService.createMeal(meal);

        // Assert
        verify(mealRepository, times(1)).save(meal);
    }

    @Test
    public void WhenCalled_CreateMeal_ShouldThrowMealNotFoundException_WhenOrderIsNull() {

        // Act
        assertThrows(MealNotFoundException.class, () -> mealService.createMeal(null));
    }
}
