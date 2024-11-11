package simple_server;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller("/")
public class simple_endpoint{

    @Get("/greet/{name}")
    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    @Get("/{num}")
    public String even(int num) {
        String response=(num % 2 == 0)?num + " is Even.": num + " is Odd";
        return response;
    }

    @Get("/get/")
    public String data() throws Exception {
        // Define a list of games
        List<String> games = Arrays.asList("Elden Ring", "Red Dead II", "God of War", "FC 24");

        // Use LinkedHashMap to preserve the insertion order
        Map<String, Object> dataMap = new LinkedHashMap<>();
        dataMap.put("Player UID", "Divin");
        dataMap.put("Games", games);
        dataMap.put("Playtime", "+100hrs");
        dataMap.put("Review", "Suffering");
        dataMap.put("Commnet", "Could've been coding");

        // Use Jackson to convert the map to a JSON string
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dataMap);
    }
}
