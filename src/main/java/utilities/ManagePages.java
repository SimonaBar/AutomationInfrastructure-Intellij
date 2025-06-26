package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {
// // Initialization of elements

    public static void initSauceDemo(){
        sauceDemoLogin= PageFactory.initElements(driver,pageObjects.saucedemo.LoginPage.class);
        sauceDemoMain= PageFactory.initElements(driver,pageObjects.saucedemo.MainPage.class);
        sauceDemoLeftMenuPage=PageFactory.initElements(driver,pageObjects.saucedemo.LeftMenuPage.class);}


        public static void initExpensMobile(){
         expenseMain=new pageObjects.atidExpenseTracker.MainPage(mobileDriver);
        }

    public static void initElectronApp(){
        electronAppMain= PageFactory.initElements(driver,pageObjects.electronApp.MainPage.class);
    }

    public static void initCalculatorApp(){
        calcAppMain= PageFactory.initElements(driver,pageObjects.calculator.MainPageCalc.class);
    }






    }





