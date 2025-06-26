package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    // we want to do a login test and to take the user and pass from the DBA that we created
    // we want to extract the user and pass so we get a list of strings. the function is getting a string query

    @Step (" Get User And Pass From Database ")
    public static List<String>getUserAndPass(String query){
        List<String>userPass=new ArrayList<>();
        try {
            rs=stmt.executeQuery(query);
            rs.next();
            userPass.add(rs.getString(1));
            userPass.add(rs.getString(2));

        } catch (Exception e) {
            e.printStackTrace();
                System.out.println("Error Occurred While Printing Table Data, See Details " + e);
            }
        return userPass;

    }


}
