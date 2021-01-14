package com.mediscreen.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;

import com.mediscreen.apigateway.filters.LoggingGatewayFilterFactory;

import reactor.core.publisher.Mono;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public GlobalFilter globalFilter() {
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            }));
        };
    }

    @Bean
    public LoggingGatewayFilterFactory getLoggingGatewayFilterFactory() {
        return new LoggingGatewayFilterFactory();
    }
}
