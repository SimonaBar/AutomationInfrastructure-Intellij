package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {
    @FindBy(className = "title")

    public WebElement head_MainPage;

    @FindBy(className = "product_sort_container")
    public WebElement combo_filter;

   // @FindBy(xpath = "//div[@class='inventory_item'][1]")
   // public WebElement first_item;

    @FindBy(xpath = "(//div[@class='inventory_item'])[1]")
    public WebElement first_item;


  //  @FindBy(css = ".btn btn_primary.btn_small.btn_inventory")
   // public WebElement btn_addtocart;
    //driver.findElement(By.cssSelector(".btn btn_primary.btn_small.btn_inventory"));


    @FindBy(css = "button.btn.btn_primary.btn_small.btn_inventory")
    public WebElement btn_addtocart;

    @FindBy(css = "button[class='btn btn_secondary btn_small btn_inventory ']")
    public WebElement btn_remove;

    @FindBy(className = "shopping_cart_badge")
    public List<WebElement> txt_numOfItems;

    @FindBy(xpath = "//div[@class='inventory_item']")
    public List<WebElement> listOfItems;













}
