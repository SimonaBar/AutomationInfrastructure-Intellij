package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    // General

    protected static WebDriverWait wait;

    protected static Actions action;

    protected static SoftAssert softAssert;
    protected static Screen screen;

    // Web
    protected static WebDriver driver;

    protected static String platform;

    // the sauceDemoLogin is a new element that we are going to initialization.
    // First we write the package and then the element

    // page objects-WEB
    protected static pageObjects.saucedemo.LoginPage sauceDemoLogin;
    protected static pageObjects.saucedemo.MainPage sauceDemoMain;
    protected static pageObjects.saucedemo.LeftMenuPage sauceDemoLeftMenuPage;

  // Mobile
    protected static AppiumDriver mobileDriver;
   protected static DesiredCapabilities dc = new DesiredCapabilities();

    // page objects- Mobile
    protected static pageObjects.atidExpenseTracker.MainPage expenseMain;

    // page objects-API
    protected static  RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params= new JSONObject();
    protected static JsonPath jp;

    //page objects- Electron
    protected static pageObjects.electronApp.MainPage electronAppMain;

    // page objects- Desktop
    protected static pageObjects.calculator.MainPageCalc calcAppMain;

    // page objects- Database
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;

    //Electron
    protected static String originalWindow;






}
