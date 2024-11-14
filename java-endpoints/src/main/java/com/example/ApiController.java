package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class ApiController {

    @Get
    public String status() {
        return "api is operational!";
    }
}
