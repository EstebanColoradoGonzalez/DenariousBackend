package com.denarious.transversal.infrastructure.controller;

import com.denarious.transversal.domain.constants.HealthConstant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static com.denarious.transversal.domain.constants.HealthConstant.OK_STATUS;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@WebFluxTest(controllers = Health.class)
class HealthTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCheckHealth() {
        // Act
        webTestClient.get().uri("/health")
                .exchange()
                // Assert
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo(OK_STATUS);
    }

    @Test
    public void testPrivateConstructor() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        // Arrange
        Constructor<HealthConstant> constructor = HealthConstant.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        // Act
        HealthConstant instance = constructor.newInstance();

        // Assert
        assertNotNull(instance);
    }
}