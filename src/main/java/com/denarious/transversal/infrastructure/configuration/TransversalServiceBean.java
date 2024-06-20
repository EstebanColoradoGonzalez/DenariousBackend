package com.denarious.transversal.infrastructure.configuration;

import com.denarious.transversal.domain.service.HealthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransversalServiceBean {
    @Bean
    public HealthService healthService() {
        return new HealthService();
    }
}