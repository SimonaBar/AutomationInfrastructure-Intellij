package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage {
    @FindBy(className = "title") // the title of the main page
    public WebElement head_MainPage;

    @FindBy(className = "product_sort_container") // combo
    public WebElement combo_filter;


    @FindBy(xpath = "(//div[@class='inventory_item'])[1]") // the first item on the page
    public WebElement first_item;


    @FindBy(css = "button.btn.btn_primary.btn_small.btn_inventory") // the btn that add to the cart
    public WebElement btn_addtocart;

    @FindBy(css = "button[class='btn btn_secondary btn_small btn_inventory ']") // remove btn
    public WebElement btn_remove;

    @FindBy(className = "shopping_cart_badge") // the number of the items in the cart
    public List<WebElement> txt_numOfItems;

    @FindBy(xpath = "//div[@class='inventory_item']") // list of all the items
    public List<WebElement> listOfItems;













}
