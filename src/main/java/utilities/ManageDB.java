package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps {




    public static void endConnection(){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error Occurred While Closing The DB, See Details " + e);
        }
    }

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
