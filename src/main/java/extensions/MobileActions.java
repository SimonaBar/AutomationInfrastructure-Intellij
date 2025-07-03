package extensions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

import java.time.Duration;

public class MobileActions extends CommonOps {
    @Step("Update Text Element")
    public static void updateText(MobileElement elem, String text){
        // wait until the element will be visible on the screen and only then I can send keys
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Click on Element")
    public static void click(MobileElement elem){
        // wait until the element will be clickable on the screen and only then I can send keys
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }


    @Step("Tap on Element") // it is like click but with more options
    public static void tap(MobileElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        TouchAction action=new TouchAction(mobileDriver);
        action.tap((new TapOptions())
                .withElement(ElementOption.element(elem))).perform();

    }
    @Step ("Swipe")

        //**
        // * Performs swipe from the center of screen
        // *
       //  * @param dir the direction of swipe
       //  * @version java-client: 7.3.0
        // **/
        public static void swipe(Direction dir) {
            System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

            // Animation default time:
            //  - Android: 300 ms
            //  - iOS: 200 ms
            // final value depends on your app and could be greater
            final int ANIMATION_TIME = 200; // ms

            final int PRESS_TIME = 200; // ms

            int edgeBorder = 10; // better avoid edges
            Point pointStart, pointEnd;
            PointOption pointOptionStart, pointOptionEnd;

            // init screen variables
            Dimension dims = driver.manage().window().getSize();

            // init start point = center of screen
            pointStart = new Point(dims.width / 2, dims.height / 2);

            switch (dir) {
                case DOWN: // center of footer
                    pointEnd = new Point(dims.width / 2, dims.height - edgeBorder);
                    break;
                case UP: // center of header
                    pointEnd = new Point(dims.width / 2, edgeBorder);
                    break;
                case LEFT: // center of left side
                    pointEnd = new Point(edgeBorder, dims.height / 2);
                    break;
                case RIGHT: // center of right side
                    pointEnd = new Point(dims.width - edgeBorder, dims.height / 2);
                    break;
                default:
                    throw new IllegalArgumentException("swipeScreen(): dir: '" + dir.toString() + "' NOT supported");
            }

            // execute swipe using TouchAction
            pointOptionStart = PointOption.point(pointStart.x, pointStart.y);
            pointOptionEnd = PointOption.point(pointEnd.x, pointEnd.y);
            System.out.println("swipeScreen(): pointStart: {" + pointStart.x + "," + pointStart.y + "}");
            System.out.println("swipeScreen(): pointEnd: {" + pointEnd.x + "," + pointEnd.y + "}");
            System.out.println("swipeScreen(): screenSize: {" + dims.width + "," + dims.height + "}");
            try {
                new TouchAction(mobileDriver)
                        .press(pointOptionStart)
                        // a bit more reliable when we add small wait
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                        .moveTo(pointOptionEnd)
                        .release().perform();
            } catch (Exception e) {
                System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
                return;
            }

            // always allow swipe action to complete
            try {
                Thread.sleep(ANIMATION_TIME);
            } catch (InterruptedException e) {
                // ignore
            }
        }
    public enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

        @Step("Zoom Element")
        public static void zoom(MobileElement elem){
            Dimension size = driver.manage().window().getSize();
            wait.until(ExpectedConditions.elementToBeClickable(elem));
            int centerX = size.width / 2;
            int centerY = size.height / 2;

            // the start point is closer to the center
            PointOption startPoint1 = PointOption.point(centerX - 50, centerY);
            PointOption startPoint2 = PointOption.point(centerX + 50, centerY);

            // the end point is far away from the center (zoom out)
            PointOption endPoint1 = PointOption.point(centerX - 200, centerY);
            PointOption endPoint2 = PointOption.point(centerX + 200, centerY);

            TouchAction action1 = new TouchAction(mobileDriver)
                    .press(startPoint1)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                    .moveTo(endPoint1)
                    .release();

            TouchAction action2 = new TouchAction(mobileDriver)
                    .press(startPoint2)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                    .moveTo(endPoint2)
                    .release();

            // 2 actions at the same time
            new MultiTouchAction(mobileDriver)
                    .add(action1)
                    .add(action2)
                    .perform();
        }


          @Step ("Zoom In- Pinch")
             public static void Pinch() {
         Dimension size = driver.manage().window().getSize();

        int centerX = size.width / 2;
        int centerY = size.height / 2;

        // the start point is far away from the center
        PointOption startPoint1 = PointOption.point(centerX - 200, centerY);
        PointOption startPoint2 = PointOption.point(centerX + 200, centerY);

        // the end point is in the center of the screen
        PointOption endPoint1 = PointOption.point(centerX - 50, centerY);
        PointOption endPoint2 = PointOption.point(centerX + 50, centerY);

        TouchAction action1 = new TouchAction(mobileDriver)
                .press(startPoint1)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(endPoint1)
                .release();

        TouchAction action2 = new TouchAction(mobileDriver)
                .press(startPoint2)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(endPoint2)
                .release();

              // 2 actions at the same time
        new MultiTouchAction(mobileDriver)
                .add(action1)
                .add(action2)
                .perform();
    }
        }









