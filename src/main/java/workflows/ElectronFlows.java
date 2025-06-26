package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

   // public static String originalWindow; i put this in the base class
    @Step("Business flow:Click On The First Demo Button and return the tittle of the new window")
    public static void newDemoButton () {
         originalWindow = driver.getWindowHandle(); // this is the ID of the original tab
        // click on the button that opens a new window
        UIActions.click1(electronAppMain.btn_newWindow);
        // wait until the new window will open לעשות

        // move to the new tab
        for (String newWindow : driver.getWindowHandles()) { // windowhandles is all the windows that are open
                driver.switchTo().window(newWindow); // now the focus is on the new window

        }


    }

    @Step("Business flow:Click On The First Demo Button and then closing the new window and return the tittle of the old window")
    public static void returnToOriginalWindow () {
        String originalWindow = driver.getWindowHandle(); // this is the ID of the original tab
        // click on the button that opens a new window
        UIActions.click1(electronAppMain.btn_newWindow);
        // wait until the new window will open לעשות

        // move to the new tab
        for (String newWindow : driver.getWindowHandles()) { // windowhandles is all the windows that are open
            driver.switchTo().window(newWindow); // now the focus is on the new window
        }
        driver.close(); // closing the new window
        driver.switchTo().window(originalWindow);

    }

    public static void electronClose (){ // זה כבר לא אותו ID
       // String originalWindow = driver.getWindowHandle(); // this is the ID of the original tab
        // move to the new tab
        driver.close(); // closing the new window
        driver.switchTo().window(originalWindow);

    }


    }












