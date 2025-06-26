package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageCalc {
    @FindBy(xpath = "//*[@AutomationId='clearButton']")
    public WebElement btn_clear;


    @FindBy(xpath = "//*[@AutomationId='num1Button']")
    public WebElement btn_one;

    @FindBy(xpath = "//*[@AutomationId='plusButton']")
    public WebElement btn_Plus;

    @FindBy(xpath = "//*[@AutomationId='num2Button']")
    public WebElement btn_Two;

    @FindBy(xpath = "//*[@AutomationId='equalButton']")
    public WebElement btn_Equals;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement filed_Result;








}
