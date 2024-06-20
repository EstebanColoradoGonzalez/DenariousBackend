package com.denarious.transversal.application.handler;

import org.springframework.transaction.annotation.Transactional;

public interface HandlerResponse<R> {
    @Transactional
    R execute();
}