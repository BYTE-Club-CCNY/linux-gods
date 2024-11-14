package ccnybyte.server;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.QueryValue;

import com.github.lalyos.jfiglet.FigletFont;

import java.util.*;

@Controller("/")

public class TeamController{
    private final String[] teamInfo = new String[3]; // Array to store team param

    // TODO: 1) return 'API is operational'

    @Get 
    @Produces(MediaType.TEXT_PLAIN)
    public String home() {
        String message = "API is operational";
        String ascii_art = "";
        try {
            ascii_art = FigletFont.convertOneLine(message);
        } catch (Exception e) {
            ascii_art = "Error generating ASCII art";
            e.printStackTrace();
        }
        return ascii_art;
    }
    
    // TODO: 2) Get and store 3 parameters
    
    @Get("get")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] getTeam(
            @QueryValue Optional<String> name,
            @QueryValue Optional<String> cohort,
            @QueryValue Optional<String> team
            ) {
        System.out.println("Query parameter values: ");
        System.out.println("Name: " + name);
        System.out.println("Cohort: " + cohort);
        System.out.println("Team: " + team);

        System.out.println("Storing parameters in array");
        teamInfo[0] = name.orElse("");
        teamInfo[1] = cohort.orElse("");
        teamInfo[2] = team.orElse("");

        System.out.println("Array elements:");
        for (String info: teamInfo) {
            System.out.println(info);
        }
        return teamInfo;
    }

/*
    @Get("greet/{name}")
    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    @Get("evenOrOdd")
    @Produces(MediaType.TEXT_PLAIN)
    public String evenOrOdd(@QueryValue Optional<Integer> num) {
        if (num.isPresent()) {
            String response=(num.get() % 2 == 0)?num.get() + " is Even.": num.get() + " is Odd";
            return response;
        } else {
            return "No number provided.";
        }
    }
*/

}
