package org.example.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Po4_ShoppingCart {
    WebDriver driver;
    WebDriverWait wait;
    public Po4_ShoppingCart(WebDriver driver) {
        this.driver=driver;
            this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
            PageFactory.initElements(driver,this);
        }


    @FindBy(css="button[class='button-2 product-box-add-to-cart-button']")
    List<WebElement> AddCartBtn;

    @FindBy(id="add-to-cart-button-4")
    WebElement CartBtn;

    @FindBy(id="bar-notification")
    WebElement NotificationMsgFrist;

    @FindBy(id="topcartlink")
    WebElement cartPge;

    @FindBy(css="button[name='continueshopping']")
    WebElement ContinueShopBtn;

    @FindBy(css = "div[class='bar-notification success']")
    WebElement NotificationMsgSecond;

    @FindBy(css = "table[class='cart'] tbody tr")
    List<WebElement> NoOfProducts;

    @FindBy(css= "span[class='cart-qty']")
    WebElement cartQuantityLoc;

    public void AddFirstProduct(){
        AddCartBtn.get(1).click();
        CartBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(NotificationMsgFrist));
        cartPge.click();
        ContinueShopBtn.click();
    }
    public void AddSecondProduct(){
        AddCartBtn.get(2).click();
        wait.until(ExpectedConditions.invisibilityOf(NotificationMsgSecond));
        cartPge.click();
    }
    public static int ConvertString_ToInt(String text){
        String NewText =text.replaceAll("[^0-9]","");
        return Integer.parseInt(NewText);
    }
    public int GetCartListQuantity(){ return ConvertString_ToInt(cartQuantityLoc.getText());}

    public int NoOFProducts(){
        return NoOfProducts.size();
    }
    }

