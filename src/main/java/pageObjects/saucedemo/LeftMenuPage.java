package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuPage {

    @FindBy(id = "react-burger-menu-btn") // This is the button that opens the menu
    public WebElement btn_menu;


    @FindBy (id = "logout_sidebar_link") // This is the logout button
    public WebElement btn_logout;



}
