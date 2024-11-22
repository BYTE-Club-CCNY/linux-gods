package ccnybyte.server;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.micronaut.serde.annotation.Serdeable;

// Notes in the serialization:
// If a string attributes is "" then it is not included in the json serialization
// If a list attribute has size zero, it is not included in the json serialization
@Serdeable
public class Project {
    private int uid;
    private String name;
    @JsonProperty("short-desc")
    private String shortDesc;
    @JsonProperty("long-desc")
    private String longDesc;
    private ArrayList<String> team;
    private String link;
    private String image;
    @JsonProperty("tech-stack")
    private ArrayList<String> techStack;
    private String cohort;
    private ArrayList<String> topic;

    public Project() {
        uid = -1;
        name = shortDesc = longDesc = link = image = cohort = "";
        team = new ArrayList<>();
        techStack = new ArrayList<>();
        topic = new ArrayList<>();
    }

    // Annotation needed to tell deserializer to convert the JSON into an object of this class using this constructor.
    // Also specifies how to map keys in the JSON object to attributes of the object
    // Only one constructor can be designated teh JsonCreator 
    @JsonCreator
    public Project(
        int uid,
        String name, 
        String shortDesc, 
        String longDesc,
        ArrayList<String> team, 
        String link, 
        String image,
        ArrayList<String> techStack, 
        String cohort, 
        ArrayList<String> topic) {
        this.uid = uid;
        this.name = name;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.team = team;
        this.link = link;
        this.image = image;
        this.techStack = techStack;
        this.cohort = cohort;
        this.topic = topic;
    }

       // Getters and setters
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public ArrayList<String> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<String> team) {
        this.team = team;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<String> getTechStack() {
        return techStack;
    }

    public void setTechStack(ArrayList<String> techStack) {
        this.techStack = techStack;
    }

    public String getCohort() {
        return cohort;
    }

    public void setCohort(String cohort) {
        this.cohort = cohort;
    }

    public ArrayList<String> getTopic() {
        return topic;
    }

    public void setTopic(ArrayList<String> topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return String.format(
            "Project {uid=%d, name='%s', shortDesc='%s', longDesc='%s', team=%s, link='%s', image='%s', techStack=%s, cohort='%s', topic=%s}",
            uid, name, shortDesc, longDesc, team, link, image, techStack, cohort, topic
        );
    }
}
