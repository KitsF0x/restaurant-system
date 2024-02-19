package io.github.kitsf0x.restaurant_system.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.github.kitsf0x.restaurant_system.model.Order;
import io.github.kitsf0x.restaurant_system.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    public void WhenCalled_CreateOrder_ShouldCallCreateOrderMethodInService() {
        // Arrange
        Order order = new Order();

        // Act
        orderController.createOrder(order);

        // Assert
        verify(orderService, times(1)).createOrder(order);
    }
}
