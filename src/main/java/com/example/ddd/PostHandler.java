package com.example.ddd;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class PostHandler {

    public Mono<ServerResponse> createHello(ServerRequest serverRequest) {
        String name = serverRequest.queryParam("name").orElse("");

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new HelloResponse(name));
    }
}
