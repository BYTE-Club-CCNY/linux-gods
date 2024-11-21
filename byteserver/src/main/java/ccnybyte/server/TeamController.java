package ccnybyte.server;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;

@Controller("/")

public class TeamController{
    private List<String[]> dataStore = new ArrayList<>();

    @Get 
    @Produces(MediaType.TEXT_PLAIN)
    public String home() {
        String message = "API is operational";
        return message;
    }

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
    
    @Get("createQuery")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        Database db = new Database();
        PreparedStatement s = db.makeQuery("ayesha", "2", "linux-gods");
        return s != null ? s.toString() : "could not create statement";
    }

    @Get("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String[]> getAllData() {
        return dataStore;
    }
}