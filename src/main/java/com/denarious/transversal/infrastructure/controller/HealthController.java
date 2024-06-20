package com.denarious.transversal.infrastructure.controller;

import com.denarious.transversal.application.query.CheckHealthHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import static com.denarious.transversal.domain.constant.APIConstant.HEALTH_API;
import static com.denarious.transversal.domain.message.APIMessage.*;

@RestController
@AllArgsConstructor
@RequestMapping(HEALTH_API)
@Tag(name = HEALTH_API_TAG)
public class HealthController {
    private final CheckHealthHandler checkHealthHandler;

    @GetMapping()
    @Operation(
            summary = CHECK_HEALTH_SUMMARY,
            description = CHECK_HEALTH_DESCRIPTION
    )
    public Mono<String> checkHealth() {
        return this.checkHealthHandler.execute();
    }
}