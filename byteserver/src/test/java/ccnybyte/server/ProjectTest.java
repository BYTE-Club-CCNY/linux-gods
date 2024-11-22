package ccnybyte.server;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import io.micronaut.serde.ObjectMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

@MicronautTest
public class ProjectTest {

    @Test
    void testWriteReadProject(ObjectMapper objectMapper) throws IOException {
        ArrayList<String> team = new ArrayList<>();
        team.add("ayesha");
        team.add("feras");
        team.add("divin");

        ArrayList<String> techStack = new ArrayList<>();
        techStack.add("Java");
        techStack.add("Micronaut");

        ArrayList<String> topic = new ArrayList<>();
        topic.add("DevOps");

        Project project = new Project(
            1, 
            "Awesome Project", 
            "Short description", 
            "Detailed description", 
            team,
            "http://team-three.com",
            "image.jpg", 
            techStack, 
            "Fall 2024", 
            topic);

        String result = objectMapper.writeValueAsString(project);

        project = objectMapper.readValue(result, Project.class);
        assertNotNull(project);
        assertEquals(1, project.getUid());
        assertEquals("Awesome Project", project.getName());
        assertEquals("Short description", project.getShortDesc());
        assertEquals("Detailed description", project.getLongDesc());
        assertEquals(team, project.getTeam());
        assertEquals("http://team-three.com", project.getLink());
        assertEquals("image.jpg", project.getImage());
        assertEquals(techStack, project.getTechStack());
        assertEquals("Fall 2024", project.getCohort());
        assertEquals(techStack, project.getTechStack());
    }

    @Test
    void testWriteReadEmptyProject(ObjectMapper objectMapper) throws IOException {
        String result = objectMapper.writeValueAsString(new Project());
        Project project = objectMapper.readValue(result, Project.class);
        assertNotNull(project);
        assertEquals(-1, project.getUid());
        assertNull(project.getName());
        assertNull(project.getShortDesc());
        assertNull(project.getLongDesc());
        assertNull(project.getTeam());
        assertNull(project.getLink());
        assertNull(project.getImage());
        assertNull(project.getTechStack());
        assertNull(project.getCohort());
        assertNull(project.getTechStack());
    }
}