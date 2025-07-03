package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;
/**
 * ElectronFlows contains business flows for testing an Electron application.
 * Handles actions like:
 * - Clicking buttons that open new windows.
 * - Switching between browser windows/tabs.
 * - Closing new windows and returning to the original window.
 * Useful for scenarios where UI interactions involve multiple windows.
 */
public class ElectronFlows extends CommonOps {

    /**
     * Clicks the "New Window" button in the Electron app,
     * then switches focus to the newly opened window.
     * Saves the original window handle for future use.
     */
    @Step("Business flow:Click On The First Demo Button and return the tittle of the new window")
    public static void newDemoButton () {
         originalWindow = driver.getWindowHandle(); // this is the ID of the original tab
        // click on the button that opens a new window
        UIActions.click1(electronAppMain.btn_newWindow);

        // move to the new tab
        for (String newWindow : driver.getWindowHandles()) { // windowhandles is all the windows that are open
                driver.switchTo().window(newWindow); // now the focus is on the new window
        }

    }
    /**
     * Clicks the "New Window" button in the Electron app,
     * switches focus to the new window, closes it,
     * and then returns focus to the original window.
     */
    @Step("Business flow:Click On The First Demo Button and then closing the new window and return the tittle of the old window")
    public static void returnToOriginalWindow () {
        String originalWindow = driver.getWindowHandle(); // this is the ID of the original tab
        // click on the button that opens a new window
        UIActions.click1(electronAppMain.btn_newWindow);
        // move to the new tab
        for (String newWindow : driver.getWindowHandles()) { // windowhandles is all the windows that are open
            driver.switchTo().window(newWindow); // now the focus is on the new window
        }
        driver.close(); // closing the new window
        driver.switchTo().window(originalWindow);

    }
    /**
     * Closes the currently active window and switches
     * focus back to the original window.
     */
    public static void electronClose (){

        driver.close(); // closing the new window
        driver.switchTo().window(originalWindow);

    }


    }












