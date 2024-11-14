package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;

import java.util.ArrayList;
import java.util.List;

@Controller("/data")
public class DataController {
    
    private List<String[]> dataStore = new ArrayList<>();
    
    @Get("/get")
    public String getData(
        @QueryValue String name, 
        @QueryValue String cohort, 
        @QueryValue String team) {

        String[] data = { name, cohort, team };
        dataStore.add(data);

        return "Data added: Name = " + name + ", Cohort = " + cohort + ", Team = " + team;
    }


@Get("/all")
public List<String[]> getAllData() {
    return dataStore;
    }
}



