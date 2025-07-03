package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)

public class SaucedemoWebDB extends CommonOps {

    @Test(description = "Test01- Verify Header After Login With User and Pass From Database")
    @Description("This Test Is Login Using Data From Database and Verifies Header")
    public void test01_loginDBAndverifyHeader() {
        WebFlows.loginDB();
        Verifications.verifyTextInElement(sauceDemoMain.head_MainPage, "Products");

    }



}
