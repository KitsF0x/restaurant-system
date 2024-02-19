package io.github.kitsf0x.restaurant_system.exception;

public class MealNotFoundException extends RuntimeException {

    public MealNotFoundException() {
        super("Meal is null or cannot be found");
    }
}
