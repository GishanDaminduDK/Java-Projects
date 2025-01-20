package com.order.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean(name = "webClient1")
    public WebClient webClient1() {
        return WebClient.builder()
                .baseUrl("http://localhost:8080/api/v1")
                .build();
    }

    @Bean(name = "webClient2")
    public WebClient webClient2() {
        return WebClient.builder()
                .baseUrl("http://localhost:8082/api/v1")
                .build();
    }
}

