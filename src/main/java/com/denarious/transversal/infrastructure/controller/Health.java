package com.denarious.transversal.infrastructure.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import static com.denarious.transversal.domain.constants.HealthConstant.OK_STATUS;

@RestController
@AllArgsConstructor
@RequestMapping("/health")
@Tag(name = "Status of the application server")
public class Health {
    @GetMapping()
    @Operation(summary = "Check the status of the application server", description = "This endpoint is used to check the status of the application where it will return an OK if the server is up")
    public Mono<String> checkHealth() {
        return Mono.just(OK_STATUS);
    }
}