package com.example.ddd;

import lombok.Getter;

@Getter
public class HelloResponse {
    private String to;
    private String job;
    private String message;

    public HelloResponse(String to, String job){
        this.to = to;
        this.job = job;
        this.message = "hello " + to;
    }
}
