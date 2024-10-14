package com.nhnacademy.minidooraycloud.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {


    @Bean
    public RouteLocator myRoute(RouteLocatorBuilder builder) {

        RouteLocator routeLocator = builder.routes()
                .route("task", p -> p.path("/task/**").and().weight("mini", 50).uri("http://localhost:9090/"))
                .route("account", p -> p.path("/account/**").and().weight("mini", 50).uri("http://localhost:7070/"))
                .build();

        return routeLocator;
    }
}
