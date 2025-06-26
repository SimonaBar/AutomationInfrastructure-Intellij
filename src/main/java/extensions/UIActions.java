package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;



public class UIActions extends CommonOps {

    // This class contains wrapper methods for common Selenium UI actions
    // such as click, text input, dropdown selection, etc.,
    // to avoid duplicating these actions in multiple test scripts.

   // @Step("Click on Element")
    //public static void click(WebElement elem){
     //   wait.until(ExpectedConditions.elementToBeClickable(elem)); // Wait until the element is clickable before performing a click
      //  elem.click();
  //  }


    @Step("Click on Element")
    public static void click1(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem)); // Wait until the element is clickable before performing a click
        elem.click();
    }

   @Step("Update Text Element")
   public static void updateText(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));// Wait until the element is visible before sending text input
        elem.sendKeys(text);
    }

    @Step("Update Text Element slow like human") // for data driven testing part1
    public static void updateTextSlow(WebElement elem,String text){
        wait.until(ExpectedConditions.visibilityOf(elem));// Wait until the element is visible before sending text input
        for (char ch:text.toCharArray()){ // Simulate slow human-like typing with a small delay between characters
         //   Uninterruptibles.sleepUninterruptibly(500,MILLISECONDS);
            elem.sendKeys(ch+ ""); // Convert single character to String before sending
        }
    }
     @Step("Update Drop Down Element")
     public static void updateDropDown(WebElement elem,String text){ // Dropdown (combo box) interaction
        wait.until(ExpectedConditions.visibilityOf(elem)); // Wait until the dropdown is visible before interacting
        Select dropDown=new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    // Methods using the Selenium Actions class
    // Useful for complex interactions like double click, mouse hover, or multi-select

    @Step("MouseHover")
    public static void mouseHover(WebElement elem1 ){
        wait.until(ExpectedConditions.visibilityOf(elem1));
        action.moveToElement(elem1).click().build().perform();

    }
    @Step("move by offset")
    public static void move(WebElement elem1 ){
        wait.until(ExpectedConditions.visibilityOf(elem1));
        action.clickAndHold(elem1).moveByOffset(100,50).release().perform();



    }

}
