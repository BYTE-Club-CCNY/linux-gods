package ccnybyte.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class Database {

    private final Dotenv env_var = Dotenv.load();

    private final String host = env_var.get("POSTGRESQL_DB_HOST"); 
    private final String port = env_var.get("POSTGRESQL_DB_PORT"); 
    private final String db = env_var.get("POSTGRESQL_DB");
    private final String user = env_var.get("POSTGRESQL_DB_USER");
    private final String password = env_var.get("POSTGRESQL_DB_PASSWORD");

    private final String url = String.format("jdbc:postgresql://%s:%s/%s", host, port, db);
    
    public Database () {
        System.out.println(url);
        testVariables();
        String status = tryConnection();
        System.out.println(status);
    }

    // Connection instance definition trial
    public String tryConnection() {
        String status;
        try (
            Connection databaseInstance = DriverManager.getConnection(url , user, password)
        ){
            status = "Database Connection Successful";
        } catch (SQLException e) {
            status = "Database Connection failed: " +
                 "\nMessage: " + e.getMessage() +
                 "\nSQL State: " + e.getSQLState() +
                 "\nError Code: " + e.getErrorCode();
        }
        return status;
    } 

    public void testVariables() {
        assert host != null : "Host missing";
        assert port != null : "Port missing";
        assert db != null : "Database name missing";
        assert user != null : "Username missing";
        assert password != null : "Passoword missing";
    }
}