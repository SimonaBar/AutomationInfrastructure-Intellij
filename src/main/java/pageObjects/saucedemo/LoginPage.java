package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    // All the elements will be private because we are using them only in this class


    @FindBy (id = "user-name") // this is the username filed when we login
    public WebElement txt_username;

    @FindBy (id = "password")
   public WebElement txt_password; // this is the password filed when we login

    @FindBy (id = "login-button")
    public WebElement btn_login; // this is the login button

    @FindBy (className = "login_logo")
    public WebElement headerMainPage; // this is the header of main page








}
