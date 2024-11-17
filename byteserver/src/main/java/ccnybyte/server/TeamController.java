package ccnybyte.server;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.QueryValue;

import java.util.*;

@Controller("/")

public class TeamController{
    private List<String[]> dataStore = new ArrayList<>();

    // TODO: 1) return 'API is operational'
    @Get 
    @Produces(MediaType.TEXT_PLAIN)
    public String home() {
        String message = "API is operational";
        return message;
    }

    // TODO: 2) Get and store 3 parameters
    @Get("get")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTeam(
            @QueryValue Optional<String> name,
            @QueryValue Optional<String> cohort,
            @QueryValue Optional<String> team
            ) {
        System.out.println("Query parameter values: ");
        System.out.println("Name: " + name);
        System.out.println("Cohort: " + cohort);
        System.out.println("Team: " + team);

        System.out.println("Storing parameters in array");
        String[] teamInfo = { name.orElse(""), cohort.orElse(""), team.orElse("") };

        dataStore.add(teamInfo);

        return "Data added: Name = " + name + ", Cohort = " + cohort + ", Team = " + team;
    }
    
    // TODO: Test Database
    @Get("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        Database db = new Database();
        String status = db.tryConnection();
        return status;
    }

    @Get("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String[]> getAllData() {
        return dataStore;
    }
}