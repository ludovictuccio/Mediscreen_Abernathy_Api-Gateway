package com.mediscreen.apigateway.filters;

import java.util.Arrays;
import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

import reactor.core.publisher.Mono;

public class LoggingGatewayFilterFactory extends
        AbstractGatewayFilterFactory<LoggingGatewayFilterFactory.Config> {

    public LoggingGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                if (config.isPostLogger()) {
                }
            }));
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("baseMessage", "preLogger", "postLogger");
    }

    public static class Config {
        private boolean preLogger;
        private boolean postLogger;

        public Config(boolean preLogger, boolean postLogger) {
            this.preLogger = preLogger;
            this.postLogger = postLogger;
        }

        public boolean isPreLogger() {
            return preLogger;
        }

        public void setPreLogger(boolean preLogger) {
            this.preLogger = preLogger;
        }

        public boolean isPostLogger() {
            return postLogger;
        }

        public void setPostLogger(boolean postLogger) {
            this.postLogger = postLogger;
        }
    }

}
