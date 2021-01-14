package com.mediscreen.apigateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class FirstPreLastPostGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
            GatewayFilterChain chain) {
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
        }));
    }

    @Override
    public int getOrder() {
        return -1;
    }

}
