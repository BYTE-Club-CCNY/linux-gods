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
        testVariables();
        tryConnection();
    }

    // Connection instance definition trial
    public void tryConnection() {
        try (
            Connection databaseInstance = DriverManager.getConnection(url , user, password)
        ){
            // pass ig
        } catch (SQLException e) {
            throw new RuntimeException(
                String.format(
                    "Database Connection failed\nMessage: %s\nSQL State: %s\nError Code: %s",
                    e.getMessage(),
                    e.getSQLState(),
                    e.getErrorCode()
                )
            );
        }
    }

    public void testVariables() {
        assert host != null : "Host missing";
        assert port != null : "Port missing";
        assert db != null : "Database name missing";
        assert user != null : "Username missing";
        assert password != null : "Passoword missing";
    }
}