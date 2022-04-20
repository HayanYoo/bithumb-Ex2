package com.example.ddd;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;



@Component
@RequiredArgsConstructor
public class PostHandler {

    private final WebClient webClient;

    public Mono<ServerResponse> createHello(ServerRequest serverRequest) {
        String name = serverRequest.queryParam("name").orElse("");
        Mono<InfoDto> infoDtoMono = webClient.get().uri("/hello").retrieve().bodyToMono(InfoDto.class);

        Mono<HelloResponse> map = infoDtoMono.map(it -> new HelloResponse(name, it.getJob()));

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(map, HelloResponse.class);
    }
}
