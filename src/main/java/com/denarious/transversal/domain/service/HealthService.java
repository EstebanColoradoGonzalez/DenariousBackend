package com.denarious.transversal.domain.service;

import reactor.core.publisher.Mono;
import static com.denarious.transversal.domain.constant.HealthConstant.OK_STATUS;

public class HealthService {
    public Mono<String> execute() {
        return Mono.just(OK_STATUS);
    }
}