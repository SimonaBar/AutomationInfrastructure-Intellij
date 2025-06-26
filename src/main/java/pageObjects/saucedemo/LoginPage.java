package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    // All the elements will be private because we are using them only in this class
    @FindBy (id = "user-name")
    public WebElement txt_username;

    @FindBy (id = "password")
   public WebElement txt_password;

    @FindBy (id = "login-button")
    public WebElement btn_login;

    @FindBy (className = "login_logo")
    public WebElement headerMainPage;


   // @FindBy (id = "login-button")
    public WebElement btn_skip; // Sometimes the site is asking us to save the password and we want to skip this






}
