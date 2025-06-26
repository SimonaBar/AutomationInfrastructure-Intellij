package workflows;
import extensions.DBActions;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import pageObjects.saucedemo.MainPage;
import utilities.CommonOps;

import java.util.List;


public class WebFlows extends CommonOps {



 // This is a business process that exists between a step and a test.
// A "step" refers to actions like a click, while a "test" is a sequence of actions including validation.
// Here, for example, we’re just performing actions like sendKeys without any validation.
// The most common action is the login operation.
// The "workflows" class combines multiple extensions, i.e., operations performed on elements.
// In the login function, we call the UIActions class because the method there is static.
// We call the updateText function, and in the parameters,
// we take the element from the ManagePage class → the LoginPage inside PageObjects, then pass in the value to input.

    @Step("Business flow: Login")
    public static void login (String user, String pass)  {
        UIActions.updateText(sauceDemoLogin.txt_username,user);
        UIActions.updateText(sauceDemoLogin.txt_password,pass);
        UIActions.click1(sauceDemoLogin.btn_login);
    }

    @Step("Business flow: Login With User and Pass From Database")
    public static void loginDB ()  {
        String query="SELECT username, pass FROM Login WHERE userId='1' ";
       List<String>userpass= DBActions.getUserAndPass(query);
        UIActions.updateText(sauceDemoLogin.txt_username,userpass.get(0));
        UIActions.updateText(sauceDemoLogin.txt_password,userpass.get(1));
        UIActions.click1(sauceDemoLogin.btn_login);
    }


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

