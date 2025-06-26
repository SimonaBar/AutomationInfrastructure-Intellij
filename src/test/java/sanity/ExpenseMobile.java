package sanity;

import extensions.Verifications;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;
import workflows.WebFlows;

import java.util.List;

@Listeners(utilities.Listeners.class)
public class ExpenseMobile extends CommonOps {

    @Test(description = "Test01- Verify Added Expenses")
    @Description("This Test Fills All The Expenses")
    public void test01_verifyExpenses() {
       MobileFlows.expenseTracker("food","100","2025-03-30","(food)");
        Verifications.verifyTextInElement(expenseMain.getExpensCategoryElement(), "Food");
    }
}