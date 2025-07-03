package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;


public class Verifications extends CommonOps {

    // Create a function that validates we have reached the next page.
    // We check that the text of the element matches what we expected.
    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    //  Verifies that the text of the given desktop element matches the expected value,
    //  after removing the fixed prefix "התצוגה היא " and trimming spaces.
    //  This is not a duplicate of verifyTextInElement; it handles cases where we
    //  need to extract only a numeric or specific value from a sentence.

    @Step("Verify Text In Element in Desktop")
    public static void verifyTextInElementInDesktop(WebElement elem1, String expected) {
         wait.until(ExpectedConditions.visibilityOf(elem1));
        assertEquals(elem1.getText().replace("התצוגה היא ", "").trim(), expected);
    }

    // Verifies that the given list of elements is empty,
    //  meaning the element does not exist on the page.
    @Step("Verify Element Does Not Exist")
    public static void verifyTextInElementNotExist(List<WebElement> elem) {
        Assert.assertTrue(elem.isEmpty());

    }

    //Checks that all elements in the list are visible on the page.
    //  Uses soft assertions to collect all visibility failures before failing the test.
    @Step("Verify Visability Of All Elements (Soft Assertion) ")
    public static void visabilityOfElements(List<WebElement> elems) {
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "Sorry The Element : " + elem.getText() + "Is Not Displayed");
        }
        softAssert.assertAll("Some Elements Were Not Displayed");
    }

    //  Performs a visual validation by searching for a specific image
    //  on the screen using Sikuli. Fails the test if the image is not found.
    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName) {
        try {
            screen.find(getData("ImageRepo" + ".png"));
        } catch (FindFailed findFailed) {
            System.out.println("Error Compering Image File" + findFailed);
            fail("Error Compering Image File" + findFailed);
        }

    }

    // Related to Data-Driven Testing during login - after login, items should appear on the page.
    //Verifies that at least one element exists in the list.
    @Step("Verify Elements Display")
    public static void itemsDisplay(List<WebElement> listOfItems) {
        assertTrue(listOfItems.size() > 0);
    }

    //Verifies that no elements exist in the list.
    // If no items appear, then it's considered a failed login (we didn’t reach the items page).
    @Step("Verify Elements Not Display")
    public static void itemsNotDisplay(List<WebElement> listOfItems) {
        assertFalse(listOfItems.size() > 0);
    }

    //Verifies that two text values are equal.
    @Step("Verify Text With Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);

    }


}








