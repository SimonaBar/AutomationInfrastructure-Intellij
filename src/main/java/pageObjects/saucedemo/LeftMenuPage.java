package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuPage {

    @FindBy(id = "react-burger-menu-btn") // This is the button that opens the menu
    public WebElement btn_menu;


  //  @FindBy (id = "inventory_sidebar_link")
   // public WebElement btn_allitems;

 //   @FindBy (id = "about_sidebar_link")
 //   public WebElement btn_about;

    @FindBy (id = "logout_sidebar_link")
    public WebElement btn_logout;

  //  @FindBy (id = "reset_sidebar_link")
  //  public WebElement btn_restappstate;




}
