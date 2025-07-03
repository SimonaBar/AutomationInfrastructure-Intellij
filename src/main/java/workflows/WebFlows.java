package workflows;
import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import pageObjects.saucedemo.MainPage;
import utilities.CommonOps;

import java.util.List;

/**
 * WebFlows contains business flows for testing the web application,
 * like performing login actions in different scenarios.
 * Combines actions from multiple layers:
 * - UI interactions (clicks, text input)
 * - Database queries for dynamic data
 * - Verifications for test validations
 * Helps keep test methods clean by grouping sequences of steps into reusable flows.
 */

public class WebFlows extends CommonOps {

    /**
     * Logs into the web application using the provided username and password.
     */
    @Step("Business flow: Login")
    public static void login (String user, String pass)  {
        UIActions.updateText(sauceDemoLogin.txt_username,user);
        UIActions.updateText(sauceDemoLogin.txt_password,pass);
        UIActions.click1(sauceDemoLogin.btn_login);
    }

    /**
     * Logs into the web application using login credentials
     * fetched dynamically from the database for userId = 1.
     * Useful for tests that require real or changing data.
     */
    @Step("Business flow: Login With User and Pass From Database")
    public static void loginDB ()  {
        String query="SELECT username, pass FROM Login WHERE userId='1' ";
       List<String>userpass= DBActions.getUserAndPass(query);
        UIActions.updateText(sauceDemoLogin.txt_username,userpass.get(0));
        UIActions.updateText(sauceDemoLogin.txt_password,userpass.get(1));
        UIActions.click1(sauceDemoLogin.btn_login);
    }

    /**
     * Logs into the web application using data-driven inputs:
     * username, password, and expected login status.
     * Steps:
     * - Opens the login page.
     * - Enters credentials slowly (simulating user typing).
     * - Clicks login.
     * - Verifies if login succeeded or failed based on expected status.
     */
    @Step("Business flow: Login With Other Users- Data Driven Test")
    public static void loginDDT (String user, String pass, String status)  {
        driver.get("https://www.saucedemo.com");
        UIActions.updateTextSlow(sauceDemoLogin.txt_username,user);
        UIActions.updateTextSlow(sauceDemoLogin.txt_password,pass);
        UIActions.click1(sauceDemoLogin.btn_login);
        if (status.equalsIgnoreCase("success"))
            Verifications.itemsDisplay(sauceDemoMain.listOfItems);
        else if (status.equalsIgnoreCase("fail"))
            Verifications.itemsNotDisplay(sauceDemoMain.listOfItems);
        else throw new RuntimeException("Invalid Password Or User Name In DDT");
    }



}

