package io.github.kitsf0x.restaurant_system.http;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import io.github.kitsf0x.restaurant_system.model.Meal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class MealHttpRoutesTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void WhenCalledPost_CreateMeal_ShouldReturnStatus200() throws Exception {

        ResponseEntity<Meal> response = testRestTemplate.postForEntity("/meals", new Meal(), Meal.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @SuppressWarnings("null")
    @Test
    public void WhenCalledPost_CreateMeal_ShouldReturnCreatedObject() throws Exception {
        // Arrange
        Meal meal = Meal.builder().name("Name").description("Description").price(new BigDecimal("3.99")).build();

        // Act
        ResponseEntity<Meal> response = testRestTemplate.postForEntity("/meals", meal, Meal.class);

        // Asert
        assertEquals(meal.getName(), response.getBody().getName());
        assertEquals(meal.getDescription(), response.getBody().getDescription());
        assertEquals(meal.getPrice(), response.getBody().getPrice());
    }
}
