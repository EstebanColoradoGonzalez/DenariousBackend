package com.denarious.transversal.domain.service;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static com.denarious.transversal.domain.constant.HealthConstant.OK_STATUS;

class HealthServiceTest {
    @Test
    void testCheckHealth() {
        // Arrange
        var healthService = new HealthService();

        // Act
        Mono<String> result = healthService.execute();

        // Assert
        StepVerifier.create(result)
                .expectNext(OK_STATUS)
                .verifyComplete();
    }
}