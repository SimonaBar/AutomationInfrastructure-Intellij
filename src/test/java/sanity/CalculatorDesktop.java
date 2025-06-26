package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)

public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test01- Verify Addition Command")
    @Description("This Verifies Addition Of Numbers 1 + 2 ")
    public void test01_verifyAdditionCommand() {
        DesktopFlows.calculateAddition();
        Verifications.verifyTextInElementInDesktop(calcAppMain.filed_Result,
                "3");
       // System.out.println(calcAppMain.filed_Result.getText());

    }



}
