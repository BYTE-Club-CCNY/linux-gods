package ccnybyte.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class Database {

    private final Dotenv env_var = Dotenv.configure()
        .ignoreIfMalformed()
        .ignoreIfMissing()
        .load();
 
    private final String host = env_var.get("POSTGRESQL_DB_HOST"); 
    private final String port = env_var.get("POSTGRESQL_DB_PORT"); 
    private final String db = env_var.get("POSTGRESQL_DB");
    private final String user = env_var.get("POSTGRESQL_DB_USER");
    private final String password = env_var.get("POSTGRESQL_DB_PASSWORD");
    private final String url = String.format("jdbc:postgresql://%s:%s/%s", host, port, db);
    
    private Connection connection;
 
    public Database () {
        assertEnvironmentVariables();
        System.out.println(tryConnection());
    }

    // Connection instance definition trial
    private String tryConnection() {
        String status;
        try {
            connection = DriverManager.getConnection(url, user, password);
            status = "Successful connection";
        } catch (SQLException e) {
            status = String.format(
                "Database Connection failed\nMessage: %s\nSQL State: %s\nError Code: %s",
                e.getMessage(),
                e.getSQLState(),
                e.getErrorCode()
            );
        }
        return status; // Return the status string
    }

    /*
     * Constructs a SQL query as a PreparedStatement object. 
     * Args:
     *  name, cohort, and team - if empty string or null, the query will not filter by that specific parameter. 
     *                           If all values are null or empty, query will have not filters, ie. all rows will be selected
     * Return: a PreparedStatement or  null if query cannot be created.
     *  
     */
    public PreparedStatement makeQuery(String name, String cohort, String team) throws SQLException {
        String query = "SELECT * FROM projects WHERE (name LIKE ? OR ? IS NULL) AND (cohort LIKE ? OR ? IS NULL);";
        PreparedStatement statement = connection.prepareStatement(query);
        
        String[] filters = {name, cohort, team};
        for (int i = 1, j = 0; i < 5; i = i + 2, j++) {
            statement.setString(i, filters[j]);
            statement.setString(i + 1, filters[j]);
        }
        return statement;
    }


    public ResultSet executeQuery(String name, String cohort, String team) {
        try {
            PreparedStatement statement = makeQuery(name, cohort, team);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println(
                e.toString()
            );
            return null;
        }
        
    }

    private void assertEnvironmentVariables() {
        assert !"".equals(host) : "Host missing";
        assert !"".equals(port) : "Port missing";
        assert !"".equals(db) : "Database name missing";
        assert !"".equals(user): "Username missing";
        assert !"".equals(password) : "Password missing";
    }
}