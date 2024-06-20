package com.denarious.transversal.infrastructure.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static com.denarious.transversal.domain.constants.HealthConstant.OK_STATUS;

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
    void checkHealthTest() {
        // Arrange
        Health healthController = new Health();

        // Act
        Mono<String> result = healthController.checkHealth();

        // Assert
        StepVerifier.create(result)
                .expectNext(OK_STATUS)
                .verifyComplete();
    }
}