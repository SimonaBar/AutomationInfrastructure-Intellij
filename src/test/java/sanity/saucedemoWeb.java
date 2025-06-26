package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)
public class saucedemoWeb extends CommonOps {

    // בגלל שהכל מוגדר סטטי, אנחנו קוראים לשם המחלקה נקודה שם הפונקציה שהיא login ובעצם פה אנחנו רושמים את כל הטסטים שלנו
    @Test(description = "Test01- Verify Header After Login")
    @Description("This Test Is Login and Verifies Header")
    public void test01_verifyHeader() {
        WebFlows.login("standard_user", "secret_sauce");
        Verifications.verifyTextInElement(sauceDemoMain.head_MainPage, "Products");


    }

    @Test(description = "Test02 - Verify Header After LogOut")
    @Description("This Test Is Logout and Verifies Header")
    public void test02_logOut() {
       //  WebFlows.login("standard_user", "secret_sauce");
        UIActions.click1(sauceDemoLeftMenuPage.btn_menu);
        UIActions.click1(sauceDemoLeftMenuPage.btn_logout);
        Verifications.verifyTextInElement(sauceDemoLogin.headerMainPage, "Swag Labs");

    }

    @Test(description = "Test03 - Add One Item To Cart")
    @Description("This Test Is Adding One Item To The Shopping Cart And Verifies The Number Of The Items In The Cart")
    public void test03_addToCart() {
        WebFlows.login("standard_user", "secret_sauce");
        UIActions.mouseHover(sauceDemoMain.first_item);
        UIActions.click1(sauceDemoMain.btn_addtocart);
        Verifications.verifyTextInElement(sauceDemoMain.txt_numOfItems.get(0), "1");

    }

    @Test(description = "Test04 - Delete One Item From The Cart")
    @Description("This Test  Deletes  One Item From The Shopping Cart And Verifies That The Element Doesn't Exist")
    public void test04_deletFromCart() {
        UIActions.click1(sauceDemoMain.btn_remove);
        Verifications.verifyTextInElementNotExist(sauceDemoMain.txt_numOfItems);

    }

    @Test(description = "Test05 - Visability of all the items")
    @Description("This Test  Verifies That All the items on the page are visible (using soft assertion)")
    public void test05_verifyItemsVisability() {
        Verifications.visabilityOfElements(sauceDemoMain.listOfItems);
    }

     @Test(description = "Test06 - verifyCartImage") // i know that this test is going to fall
      @Description("This Test  Verifies The Cart Image Using Sikuli Tool")
      public void test06_verifyCartImage() {
       Verifications.visualElement("SouceDemoCart");

      }
    @Test(description = "Test07 - logIn With Other Users",dataProvider = "data-provider-users",dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Checks The Login With Different Users-DDT ")
    public void test07_verifyLoginDDT(String user,String pass,String status)
    {
        WebFlows.loginDDT(user,pass,status);

    }
}