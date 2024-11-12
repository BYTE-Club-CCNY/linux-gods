package ccnybyte.server;

import java.util.Optional;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;

@Controller("/")
public class TeamController {
    private final String[] teamInfo = new String[3];
    
    @Get
    @Produces(MediaType.TEXT_PLAIN)
    public String index() {
        return "api is operational";
    }

    @Get("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] getTeam(@QueryValue Optional<String> name, @QueryValue Optional<String> cohort, @QueryValue Optional<String> team) {
        System.out.println("Query parameter values:");
        System.out.println("Name: " + name);
        System.out.println("Cohort: " + cohort);
        System.out.println("Team: " + team);

        System.out.println("Storing values in array...");
        teamInfo[0] = name.orElse("");
        teamInfo[1] = cohort.orElse("");
        teamInfo[2] = team.orElse("");

        System.out.println("Array elements:");
        for (String info : teamInfo) {
            System.out.println(info);
        }

        return teamInfo;
    }

}
