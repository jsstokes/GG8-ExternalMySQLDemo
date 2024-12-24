package mysqljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLJDBCTest {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        // Database connection details
        String host = "jdbc:mysql://localhost:3306/STOKES";
        String username = "root";
        String password = "Passw0rd";

        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(host, username, password);

            // Create a statement object
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM names");

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
            }

            // Close the connection
            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
