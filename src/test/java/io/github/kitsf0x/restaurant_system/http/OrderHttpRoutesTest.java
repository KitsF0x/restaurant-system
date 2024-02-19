package io.github.kitsf0x.restaurant_system.http;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.github.kitsf0x.restaurant_system.model.Order;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class OrderHttpRoutesTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void whenCalled_PostRoute_shouldReturnStatus200() throws Exception {
        ResponseEntity<Order> response = testRestTemplate.postForEntity("/orders", new Order(), Order.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @SuppressWarnings("null")
    @Test
    public void whenCalled_PostRoute_shouldReturnCreatedObject() throws Exception {
        // Arrange
        String orderNote = "Note of the order";
        Order order = Order.builder().note(orderNote).build();

        // Act
        ResponseEntity<Order> response = testRestTemplate.postForEntity("/orders", order, Order.class);

        // Assert
        assertNotNull(response.getBody());
        assertEquals(orderNote, response.getBody().getNote());
    }
}