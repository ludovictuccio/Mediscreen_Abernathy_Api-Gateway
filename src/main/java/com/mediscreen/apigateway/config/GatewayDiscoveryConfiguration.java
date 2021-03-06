package com.mediscreen.apigateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mediscreen.apigateway.filters.LoggingGatewayFilterFactory;
import com.mediscreen.apigateway.filters.LoggingGatewayFilterFactory.Config;

@Configuration
@EnableDiscoveryClient
public class GatewayDiscoveryConfiguration {

    @Autowired
    private LoggingGatewayFilterFactory loggingFactory;

    @Value("${proxy.patient}")
    public String URI_MICROSERVICE_PATIENT_8081;

    @Value("${proxy.notes}")
    public String URI_MICROSERVICE_NOTES_8082;

    @Value("${proxy.reports}")
    public String URI_MICROSERVICE_REPORTS_8083;

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes().route(r -> r.path("/api/patient/**").filters(
                f -> f.filter(loggingFactory.apply(new Config(true, true))))
                .uri(URI_MICROSERVICE_PATIENT_8081))
                .route(r -> r.path("/api/note/**")
                        .filters(f -> f.filter(
                                loggingFactory.apply(new Config(true, true))))
                        .uri(URI_MICROSERVICE_NOTES_8082))
                .route(r -> r.path("/api/reports/**")
                        .filters(f -> f.filter(
                                loggingFactory.apply(new Config(true, true))))
                        .uri(URI_MICROSERVICE_REPORTS_8083))
                .build();
    }

}