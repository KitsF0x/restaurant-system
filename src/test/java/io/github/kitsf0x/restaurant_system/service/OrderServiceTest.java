package io.github.kitsf0x.restaurant_system.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import io.github.kitsf0x.restaurant_system.exception.OrderNotFoundException;
import io.github.kitsf0x.restaurant_system.model.Order;
import io.github.kitsf0x.restaurant_system.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @SuppressWarnings("null")
    @Test
    public void WhenCalled_CreateOrder_SaveOrderInRepository() {
        // Arrange
        String orderNote = "Note of the order";
        Order order = Order.builder().note(orderNote).build();
        when(orderRepository.save(order)).thenReturn(order);

        // Act
        orderService.createOrder(order);

        // Assert
        verify(orderRepository, times(1)).save(order);

    }

    @Test
    public void WhenCalled_CreateOrder_ShouldThrowOrderNotFoundException_WhenOrderIsNull() {

        // Act
        assertThrows(OrderNotFoundException.class, () -> orderService.createOrder(null));
    }

    @Test
    public void WhenCalled_GetById_ShouldCallFindByIdInRepository() {
        // Arrange
        when(orderRepository.findById(anyInt())).thenReturn(Optional.of(new Order()));

        // Act
        orderService.getById(1);

        // Assert
        verify(orderRepository, times(1)).findById(1);
    }

    @Test
    public void WhenCalled_GetById_ShouldThrowOrderNotFoundException_WhenWithGivenIdWasNotFound() {
        // Arrange
        when(orderRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act
        assertThrows(OrderNotFoundException.class, () -> orderService.getById(1));
    }
}
