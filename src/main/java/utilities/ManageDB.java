package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Handles operations related to database connections
 * such as opening and closing connections to SQLite.
 * This class extends CommonOps to use shared variables like 'con' and 'stmt'.
 */

public class ManageDB extends CommonOps {
    /**
     * Closes the existing database connection if it is open.
     * Ensures that resources are released properly at the end of testing.
     * Prints an error message if closing fails.
     */

    public static void endConnection(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occurred While Closing The DB, See Details " + e);
        }
    }

    /**
     * Opens a connection to a SQLite database using the JDBC driver.
     * Builds the JDBC URL based on the given database path,
     * and creates a Statement object for executing SQL queries.
     */
    public static void openConnection(String dbPath) {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:" + dbPath;
            con = DriverManager.getConnection(url);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred While Connecting To DB:");
            e.printStackTrace();
        }
    }



}
