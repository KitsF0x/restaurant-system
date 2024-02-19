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
import org.springframework.test.annotation.DirtiesContext;

import io.github.kitsf0x.restaurant_system.model.Order;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderHttpRoutesTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void WhenCalled_PostOrder_ShouldReturnStatus200() throws Exception {
        ResponseEntity<Order> response = testRestTemplate.postForEntity("/orders", new Order(), Order.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @SuppressWarnings("null")
    @Test
    public void WenCalled_PostOrder_ShouldReturnCreatedObject() throws Exception {
        // Arrange
        String orderNote = "Note of the order";
        Order order = Order.builder().note(orderNote).build();

        // Act
        ResponseEntity<Order> response = testRestTemplate.postForEntity("/orders", order, Order.class);

        // Assert
        assertNotNull(response.getBody());
        assertEquals(orderNote, response.getBody().getNote());
    }

    @Test
    public void WenCalled_GetOrder_ShouldReturnStatus404_WhenOrderWasNotFound() throws Exception {
        // Act
        ResponseEntity<Order> response = testRestTemplate.getForEntity("/orders/1", Order.class);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void WenCalled_GetOrder_ShouldReturnStatus200_WhenOrderWasFound() throws Exception {
        // Act
        testRestTemplate.postForEntity("/orders", new Order(0, "Note"), Order.class);
        ResponseEntity<Order> response = testRestTemplate.getForEntity("/orders/1", Order.class);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @SuppressWarnings("null")
    @Test
    public void WenCalled_GetOrder_ShouldReturnCreatedObject_IfExists() throws Exception {
        // Arrange
        String orderNote = "Note of the order";
        Order order = Order.builder().note(orderNote).build();
        testRestTemplate.postForEntity("/orders", order, Order.class);

        // Act
        ResponseEntity<Order> response = testRestTemplate.getForEntity("/orders/1", Order.class);

        // Assert
        assertNotNull(response.getBody());
        assertEquals(orderNote, response.getBody().getNote());
    }
}