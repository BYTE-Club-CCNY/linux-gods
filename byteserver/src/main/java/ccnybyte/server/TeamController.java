package ccnybyte.server;

import java.util.ArrayList;
import java.util.Optional;

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
    @Produces(MediaType.TEXT_PLAIN)
    public String getTeam(
            @QueryValue Optional<String> name,
            @QueryValue Optional<String> cohort,
            @QueryValue Optional<String> team
            ) {
    
        return "Data added: Name = " + name.orElse("") + ", Cohort = " + cohort.orElse("")+ ", Team = " + team.orElse("");
    }


    @Get("project") 
    public Project getProject() {
        ArrayList<String> team = new ArrayList<>();
        team.add("ayesha");
        team.add("feras");
        team.add("divin");

        ArrayList<String> techStack = new ArrayList<>();
        techStack.add("Java");
        techStack.add("Micronaut");

        ArrayList<String> topic = new ArrayList<>();
        topic.add("DevOps");

        Project project = new Project(1, "Awesome Project", "Short description", "Detailed description", team,
                                    "http://team-three.com", "image.jpg", techStack, "Fall 2024", topic);
        System.out.println(project);
        return project;
    }


    @Get("project1") 
    public Project getProject1() {
        Project empty = new Project();
        System.out.println(empty);
        return empty;
    }
}