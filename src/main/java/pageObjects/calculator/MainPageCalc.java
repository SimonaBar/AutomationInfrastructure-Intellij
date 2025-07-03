package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageCalc {
    @FindBy(xpath = "//*[@AutomationId='clearButton']") // the clear button
    public WebElement btn_clear;


    @FindBy(xpath = "//*[@AutomationId='num1Button']") // button number 1
    public WebElement btn_one;

    @FindBy(xpath = "//*[@AutomationId='plusButton']") // plus button
    public WebElement btn_Plus;

    @FindBy(xpath = "//*[@AutomationId='num2Button']") // button number 2
    public WebElement btn_Two;

    @FindBy(xpath = "//*[@AutomationId='equalButton']") //  the equals button
    public WebElement btn_Equals;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']") // the field result
    public WebElement filed_Result;


}
