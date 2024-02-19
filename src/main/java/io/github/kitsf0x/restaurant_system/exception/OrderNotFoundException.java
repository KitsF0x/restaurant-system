package io.github.kitsf0x.restaurant_system.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {
        super("Order is null or cannot be found");
    }
}
