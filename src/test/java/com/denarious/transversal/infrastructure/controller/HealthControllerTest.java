package com.denarious.transversal.infrastructure.controller;

import com.denarious.transversal.application.query.CheckHealthHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import static com.denarious.transversal.domain.constant.APIConstant.HEALTH_API;
import static com.denarious.transversal.domain.constant.HealthConstant.OK_STATUS;
import static com.denarious.transversal.domain.constant.NumberConstant.ONE_CALL;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@WebFluxTest(controllers = HealthController.class)
class HealthControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private CheckHealthHandler checkHealthHandler;

    @BeforeEach
    void setUp() {
        // Arrange
        when(checkHealthHandler.execute()).thenReturn(Mono.just(OK_STATUS));
    }

    @Test
    void checkHealth_ReturnsOkStatus() {
        // Act:
        webTestClient.get()
                .uri(HEALTH_API)
                .exchange()

                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo(OK_STATUS);

        verify(checkHealthHandler, times(ONE_CALL)).execute();
    }
}