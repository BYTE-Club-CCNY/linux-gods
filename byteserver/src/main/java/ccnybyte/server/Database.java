package ccnybyte.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import io.github.cdimascio.dotenv.Dotenv;

public class Database {

    private final Dotenv env_var = Dotenv.load();

    private final String host = env_var.get("POSTGRESQL_DB_HOST"); 
    private final String port = env_var.get("POSTGRESQL_DB_PORT"); 
    private final String db = env_var.get("POSTGRESQL_DB");
    private final String user = env_var.get("POSTGRESQL_DB_USER");
    private final String password = env_var.get("POSTGRESQL_DB_PASSWORD");

    private final String url = String.format("jdbc:postgresql://%s:%s/%s", host, port, db);
    private Connection connection;

    public Database () {
        testVariables();
        String status = tryConnection();
        System.out.println(status);
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
    public PreparedStatement makeQuery(String name, String cohort, String team) {
        try {
            String query = "SELECT * FROM projects";
            Map<String, String> filters = new HashMap<>();
            
            // add name filter if name is provided
            if (name != null && !name.equals("")) {
                filters.put("name", name);
            }

            // add cohort filter if cohort is provided
            if (cohort != null && !cohort.equals("")) {
                filters.put("cohort", cohort);
            }
            
            // add team filter if team is provided
            if (team != null && !team.equals("")) {
                filters.put("team", team);
            }

            // build query using provided filters
            query = !filters.isEmpty() ? query + " WHERE" : query;
            int index = 0;
            for (String filter : filters.keySet()) {
                query += String.format(
                        " %s ILIKE ?%s", 
                        filter, 
                        index == filters.size() - 1 ? "" : " AND"
                    );
                index++;
            }
            System.out.println(query);

            // create statement, may throw SQLException
            PreparedStatement statement = connection.prepareStatement(query);

            // set actual filter values, ie replace ? with the filter arguments passed in
            // this leverages the PreparedStatement's built-in protection against SQL injection attacks 
            index = 1;
            for (String value: filters.values()) {
                statement.setString(index++, value);
            }

            System.out.println(statement);
            return statement;
            
        } catch (SQLException e) {
            // if we cannot build the query, return null to indicate failure
            System.out.println("ERROR: could not create SQL query");
            return null;
        }
    }

    // ** executeQuery **
    // returns result set of makeQuery 
public ResultSet executeQuery(String name, String cohort, String team) {
    
    // Get the PreparedStatement from makeQuery ^
    PreparedStatement statement = makeQuery(name, cohort, team);
    
    if (statement == null) {
        System.out.println("Error: Query was not created.");
        return null;
    }

    try {
        // Executes the query and then returns the result
        return statement.executeQuery();
    } catch (SQLException e) {
        System.out.println("Error executing query: " + e.getMessage());
        return null;
    }
}

    private void testVariables() {
        assert host != null : "Host missing";
        assert port != null : "Port missing";
        assert db != null : "Database name missing";
        assert user != null : "Username missing";
        assert password != null : "Password missing";
    }
}