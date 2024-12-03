package ccnybyte.server;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import java.sql.ResultSet;
import java.sql.SQLException;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;

@Controller("/")

public class TeamController{
    private Database db = new Database();

    @Get 
    @Produces(MediaType.TEXT_PLAIN)
    public String home() {
        return "API is operational";
    }

    @Get("get")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<String> getTeam(
        @QueryValue Optional<String> name,
        @QueryValue Optional<String> cohort,
        @QueryValue Optional<String> team
    ) { 
        ArrayList<String> datastore = new ArrayList<>();
        try {
            ResultSet result = db.executeQuery(name, cohort, team);
            while (result.next()) {
                Project proj = new Project(
                    result.getInt(1),  // uid
                    result.getString(2),  // name
                    result.getString(3),  // short-desc
                    result.getString(4),  // long-desc
                    new ArrayList<>(List.of((String[]) result.getArray(5).getArray())), // team
                    result.getString(6),  // link
                    result.getString(7),  // image
                    new ArrayList<>(List.of((String[]) result.getArray(8).getArray())), // tech-stack
                    result.getString(9),  // cohort
                    new ArrayList<>(List.of((String[]) result.getArray(10).getArray())) // topic
                );

                datastore.add(proj.toString());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Database query failed: " + e.getMessage(), e);
        }
        return datastore;
    }
}