package ccnybyte.server;

import java.sql.*;

import io.github.cdimascio.dotenv.Dotenv;

public class Database {

    private final Dotenv env_var = Dotenv.load();

    private final String host = env_var.get("POSGRESQL_DB_HOST"); 
    private final String port = env_var.get("POSTGRESQL_DB_PORT"); 
    private final String db = env_var.get("POSTGRESQL_DB");
    private final String user = env_var.get("POSTGRESQL_DB_USER");
    private final String password = env_var.get("POSTGRESQL_DB_PASSWORD");

    private final String url = "jdbc:postgresql://" + host + ":" + port + "/" + db;

    // Connection instance definition trial
    public String tryConnection() {
        String status;
        try (
            Connection database_instance = DriverManager.getConnection(url , user, password)
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
}