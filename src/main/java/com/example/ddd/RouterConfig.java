package com.example.ddd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> route(PostHandler postHandler) {
        return RouterFunctions.route()
                .GET("/hello",
//                        accept(MediaType.APPLICATION_JSON),
                        postHandler::createHello)
                .build();

    }


//    @Bean
//    public RouterFunction<ServerResponse> getRoute(PostHandler postHandler) {
//        return RouterFunctions.route()
//                .path("/hello", builder -> builder
//                        .GET("", accept(APPLICATION_JSON), postHandler::createHello)
//                )
//                .build();
//
//
//    }



}
