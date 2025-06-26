package utilities;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import workflows.ElectronFlows;


public class CommonOps extends Base {
   // we extend the Base because we want that the driver will be familiar here in the endSession.

   // we are checking  the browser type that  we are using, and now we have a new method called initChromeDriver


   // this is a func that know how to read XML file
   public static String getData(String nodeName) {
      DocumentBuilder dBuilder;
      Document doc = null;
      File fXmlFile = new File("./Configuration/DataConfig.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      try {
         dBuilder = dbFactory.newDocumentBuilder();
         doc = dBuilder.parse(fXmlFile);
      }
      catch(Exception e) {
         System.out.println("Exception in reading XML file: " + e);
      }
      doc.getDocumentElement().normalize();
      return doc.getElementsByTagName(nodeName).item(0).getTextContent();
   }



   public static void initBrowser(String browserType){
      if (browserType.equalsIgnoreCase("chrome"))
         driver=initChromeDriver();
      else if (browserType.equalsIgnoreCase("firefox"))
         driver=initFirefoxDriver();
      else if (browserType.equalsIgnoreCase("ie"))
         driver=initIEDriver();
      else
         throw new RuntimeException("Invalid Browser Type");
      if (!platform.equalsIgnoreCase("electron")){ //אפליקצית אלקטרון לא להגדיל מסך
         driver.manage().window().maximize();
      }
      driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
      wait=new WebDriverWait(driver,Long.parseLong(getData("TimeOut")));
      driver.manage().window().maximize();
      driver.get(getData("Url"));
      ManagePages.initSauceDemo(); // This function initializes the Page Objects
      action= new Actions(driver);


   }

    public static WebDriver initChromeDriver(){
      WebDriverManager.chromedriver().setup();
     ChromeOptions options = new ChromeOptions();

    options.setExperimentalOption("prefs", java.util.Map.of(
     "credentials_enable_service", false,
       "profile.password_manager_enabled", false
     ));

    options.addArguments("--incognito");

     WebDriver driver = new ChromeDriver(options);
     return driver;
     }



   public static WebDriver initFirefoxDriver(){
      WebDriverManager.firefoxdriver().setup();
      WebDriver driver= new FirefoxDriver();
      return driver;
   }

   public static WebDriver initIEDriver(){
      WebDriverManager.iedriver().setup();
      WebDriver driver= new InternetExplorerDriver();
      return driver;
   }
   public static void  initMobile(){
      dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
      dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
      dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
      try {
         mobileDriver = new AndroidDriver(new URL(getData("AppiumServer")), dc);
      } catch (Exception e) {
         System.out.println("can not connect to appium server, see details : "+ e);
      }
      ManagePages.initExpensMobile();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
      wait=new WebDriverWait(mobileDriver,Long.parseLong(getData("TimeOut")));
      action= new Actions(driver);
   }

   public static void initAPI(){
      RestAssured.baseURI=getData("UrlAPI");
      httpRequest=RestAssured.given();
   }

   public static void initDesktop(){
      dc.setCapability("app",getData("CalculatorApp"));
      try {
         driver= new WindowsDriver(new URL(getData("AppiumServerDesktop")),dc);
      } catch (Exception e) {
         System.out.println("Can not Connect to Appium Server, See Details: "+e);
      }
       mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
      wait=new WebDriverWait(mobileDriver,Long.parseLong(getData("TimeOut")));
      ManagePages.initCalculatorApp();

   }

   public static void initElectron(){
      System.setProperty("webdriver.chrome.driver",getData("ElectronDriverPath"));
      ChromeOptions opt=new ChromeOptions();
      opt.setBinary(getData("ElectronAppPath")); // We define where is the app saved in our computer
      dc.setCapability("chromeOptions",opt);
      dc.setBrowserName("chrome");
      driver=new ChromeDriver(dc);
      ManagePages.initElectronApp();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
      wait=new WebDriverWait(mobileDriver,Long.parseLong(getData("TimeOut")));
      action= new Actions(driver);



   }

   @BeforeClass
   @Parameters({"PlatFormName"}) // this is the connection to the swit xml file
   public void startSession(String PlatformName){
      // I want to support all the drivers and not just Chromedriver as we did before. we will improve the code afterward
      // I am running the test on the web first
      // If I want to run the tests on the web, we will get to the method initBrowser
      platform=PlatformName;
      if (platform.equalsIgnoreCase("web"))
         initBrowser(getData("BrowserName"));
      else if (platform.equalsIgnoreCase("mobile"))
         initMobile();
      else if (platform.equalsIgnoreCase("api"))
         initAPI();
      else if (platform.equalsIgnoreCase("electron"))
         initElectron();
      else if (platform.equalsIgnoreCase("desktop"))
         initDesktop();
      else
         throw new RuntimeException("Invalid Platform Name");
      softAssert=new SoftAssert();
      screen=new Screen();
      ManageDB.openConnection(getData("DBURL"));

   }

   @AfterClass
   public void endSession(){
      if (!platform.equalsIgnoreCase("api")){
         if (!platform.equalsIgnoreCase("mobile"))
            driver.quit();
         else
            mobileDriver.quit();
      }

   }

   @AfterMethod
   public void returnToMain(){
      if (platform.equalsIgnoreCase("web"))
         driver.get("https://www.saucedemo.com/inventory.html");
      //driver.get(getData("UrlMain"));

   }



   @BeforeMethod
   public void beforeMethod(Method method){
      if (!platform.equalsIgnoreCase("api")){
         try {
            MonteScreenRecorder.startRecord(method.getName());
         } catch (Exception e) {
            throw new RuntimeException(e);
         }

      }

   }



}
