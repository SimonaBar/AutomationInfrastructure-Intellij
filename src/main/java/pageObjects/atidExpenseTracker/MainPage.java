package pageObjects.atidExpenseTracker;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private AppiumDriver mobileDriver;
    public MainPage(AppiumDriver mobileDriver){
        this.mobileDriver=mobileDriver;

    }

    // Elements
    private By txt_expenseName= By.id("expense-name");  // Manually enter the expense name
    private By txt_expenseAmount= By.id("expense-amount"); // Manually enter the expense amount
    private By date_expenseDate= By.id("expense-date"); // Select a specific date

    private By Full_date_expenseDate= By.xpath("//*[@text='30']"); // בחירת תאריך ספציפי
    private By btn_choose= By.id("button1"); // Button to confirm the date selection


    private By dropDown_expenseCategory= By.id("expense-category"); // Expense categories dropdown

    private By listOfExpenseCategory= By.xpath("//*[@text='Food']"); // Select a specific category

    private By btn_addExpense= By.id("add-expense");// Button to add expense
    private By txt_expensBlock= By.id("expense-list"); // Expense list block




    //Getters
    public AndroidElement getExpenseNameElement(){
        return (AndroidElement) mobileDriver.findElement(txt_expenseName);
    }

    public AndroidElement getExpenceAmountElement(){
        return (AndroidElement) mobileDriver.findElement(txt_expenseAmount);
    }

    public AndroidElement getExpenseDatElement(){
        return (AndroidElement) mobileDriver.findElement(date_expenseDate);
    }

    public AndroidElement getBtnExpenseDatElement(){
        return (AndroidElement) mobileDriver.findElement(btn_choose);
    }

    public AndroidElement getDatElement(){
        return (AndroidElement) mobileDriver.findElement(Full_date_expenseDate);
    }

    public AndroidElement getExpensCategoryElement(){
        return (AndroidElement) mobileDriver.findElement(dropDown_expenseCategory);
    }

    public AndroidElement AddExpenseElement(){
        return (AndroidElement) mobileDriver.findElement(listOfExpenseCategory);
    }
    public AndroidElement getAddExpenseElement(){
        return (AndroidElement) mobileDriver.findElement(btn_addExpense);
    }



    public AndroidElement getExpenseBlockElement(){
        return (AndroidElement) mobileDriver.findElement(txt_expensBlock);
    }


}
