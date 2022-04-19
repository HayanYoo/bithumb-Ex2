package com.example.ddd;

import lombok.Getter;

@Getter
public class HelloResponse {
    private String to;
    private String message;

    public HelloResponse(String to){
        this.to = to;
        this.message = "hello " + to;
    }
}
