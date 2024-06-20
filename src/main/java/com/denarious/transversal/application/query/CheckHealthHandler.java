package com.denarious.transversal.application.query;

import com.denarious.transversal.application.handler.HandlerResponse;
import com.denarious.transversal.domain.service.HealthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CheckHealthHandler implements HandlerResponse<Mono<String>> {
    private final HealthService healthService;

    @Override
    public Mono<String> execute() {
        return this.healthService.execute();
    }
}