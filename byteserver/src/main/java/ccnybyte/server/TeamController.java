package ccnybyte.server;

import java.sql.ResultSet;
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
    private Database db = new ccnybyte.server.Database();

    @Get 
    @Produces(MediaType.TEXT_PLAIN)
    public String home() {
        return "API is operational";
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
        String[] teamInfo = { name.orElse(null), cohort.orElse(null), team.orElse(null) };

        dataStore.add(teamInfo);

        return "Data added: Name = " + name + ", Cohort = " + cohort + ", Team = " + team;
    }
    
    @Get("createQuery")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        ResultSet s = db.executeQuery("ayesha", "2", null);
        return s != null ? s.toString() : "could not create statement";
    }

    @Get("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String[]> getAllData() {
        return dataStore;
    }
}