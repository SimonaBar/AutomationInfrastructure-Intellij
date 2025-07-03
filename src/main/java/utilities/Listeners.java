package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

/**
 * Implements TestNG listeners to handle test execution events
 * like test start, success, failure, and skip.
 * Responsible for stopping video recordings and attaching screenshots
 * to Allure reports for better debugging and traceability.
 */

public class Listeners extends CommonOps implements ITestListener {
    /**
     * Runs once before any tests start executing.
     * Logs a message to indicate the beginning of the test suite execution.
     */
    public void onStart(ITestContext execution) {
        System.out.println("----------------- Starting Execution ---------------");
    }

    /**
     * Runs once after all tests in the suite have finished.
     * Logs a message indicating the end of the execution.
     */

    public void onFinish(ITestContext execution) {
        System.out.println("----------------- Ending Execution ---------------");
    }

    /**
     * Placeholder for handling cases where a test fails
     * but still falls within a configured success percentage.
     * Not implemented in this project.
     */

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO implement this...
    }
    /**
     * Runs when a test is skipped.
     * Logs the skipped test's name for reporting purposes.
     */
    public void onTestSkipped(ITestResult test) {
        System.out.println("----------- Skipping Test:" + test.getName() + " -------------");
    }

    /**
     * Runs right before the execution of each test method.
     * Logs the test name to indicate that the test is starting.
     */
    public void onTestStart(ITestResult test) {
        System.out.println("----------- Starting Test:" + test.getName() + " -------------");
    }

    /**
     * Runs after a test method has executed successfully without errors.
     * Stops the video recording for the test, and deletes the video file
     * to save disk space.
     */
    public void onTestSuccess(ITestResult test) {
        System.out.println("----------- Test:" + test.getName() + " Passed -------------");
       // stop recording
        if (!platform.equalsIgnoreCase("api")){
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            // delete recorded file
            File file=new File("./test-recordings/"+test.getName()+".avi");
            if (file.delete())
                System.out.println("File Deleted Successfully");
            else
                System.out.println("Failed to  Deleted File");

        }

    }
    /**
     * Runs after a test method fails.
     * Stops video recording and captures a screenshot,
     * which is attached to the Allure report to help with debugging.
     */
    public void onTestFailure(ITestResult test) {
        System.out.println("----------- Test:" + test.getName() + " Failed -------------");
        // stop recording
        if (!platform.equalsIgnoreCase("api")){
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }

            saveScreenshot();

        }


    }

    /**
     * Captures a screenshot of the current browser or mobile screen
     * and attaches it to the Allure report as a PNG image.
     * This helps identify the state of the app or website at the time of failure.
     * @return a byte array containing the screenshot image data
     */

    @Attachment(value = "Screenshot", type = "image/png")

    public byte[] saveScreenshot() {
        if (!platform.equalsIgnoreCase("mobile"))
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot) mobileDriver).getScreenshotAs(OutputType.BYTES);
    }

}
