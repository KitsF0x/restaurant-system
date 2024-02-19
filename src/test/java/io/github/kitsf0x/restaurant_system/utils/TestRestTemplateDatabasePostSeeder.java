package io.github.kitsf0x.restaurant_system.utils;

import org.springframework.boot.test.web.client.TestRestTemplate;

public class TestRestTemplateDatabasePostSeeder<T> {
    public void seed(TestRestTemplate template, String uri, T object) {
        template.postForEntity(uri, object, object.getClass());
    }
}
