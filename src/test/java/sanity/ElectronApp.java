package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.electronApp.MainPage;
import utilities.CommonOps;
import workflows.ElectronFlows;


@Listeners(utilities.Listeners.class)
public class ElectronApp extends CommonOps {

    @Test(description = "Test01- Click on The Firs Demo Button And Verify The Tittle Of The New Window")
    @Description("This Test clicks on the first demo button And Verify The Tittle Of The New Window")
    public void test01_clickAndVerifyNewWindow() {
         ElectronFlows.newDemoButton();
      Verifications.verifyTextInElement(MainPage.txt_helloWorld,"Hello World!");
      ElectronFlows.electronClose();



    }

    @Test(description = "Test02- Click on The Firs Demo Button And Return To The Main Page And Verify The Tittle Of The Main Window")
    @Description("This Test Returns To The Main Page And Verify The Tittle Of The Main Window")
    public void test02_clickAndVerifyMainWindow() {
        ElectronFlows.returnToOriginalWindow();
        Verifications.verifyTextInElement(MainPage.btn_FirstnewWindow,"Create a new window\n" +
                "SUPPORTS: WIN, MACOS, LINUX | PROCESS: MAIN");

    }





    }




