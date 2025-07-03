package pageObjects.electronApp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonOps;

public class MainPage  {
    @FindBy(id = "new-window-demo-toggle")
    public static WebElement btn_FirstnewWindow;

// this is the first button of view demo that opens a new window
    @FindBy(id = "new-window")
    public static WebElement btn_newWindow;

    // this is the element in the new window from the first button
    @FindBy(tagName = "h2")
    public static WebElement txt_helloWorld;

    // this is the element in the new window that i can click and close the new window.
    @FindBy(id = "close")
    public WebElement txt_close;
///////////////////////////////////////////////////////////////////

    // this is the button that opens the second new window
    @FindBy(id = "manage-window")
    public WebElement btn_manageWindow;

    // this is the button in the new window
    @FindBy(tagName = "p")
    public WebElement newWindow;









}
