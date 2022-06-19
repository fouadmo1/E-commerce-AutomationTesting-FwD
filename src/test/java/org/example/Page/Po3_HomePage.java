package org.example.Page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class Po3_HomePage {
    WebDriver driver;
    Actions actions;
    public Po3_HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "customerCurrency")
    WebElement CustomerCurrencies;

    @FindBy(id = "small-searchterms")
    WebElement SearchField;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    WebElement Searchbtn;

    @FindBy(css = "span[class=\"price actual-price\"]")
    List <WebElement> productPrices;

    @FindBy(css = "h2[class=\"product-title\"]")
    WebElement Searchesult ;


    @FindBy(xpath = "//div[@class='header-menu']/ul[1]/li")
    List <WebElement> Categories;

    @FindBy(xpath = "//li[@class='active last']/ul/li/a")
    List<WebElement> SubCategories;

    @FindBy(className = "facebook")
    WebElement Facebook;
    @FindBy(className = "twitter")
    WebElement twitter;
    @FindBy(className = "rss")
    WebElement rss;
    @FindBy(className = "youtube")
    WebElement youtube;
    @FindBy(className = "bar-notification")
    public WebElement NotiMsgLoc;

    @FindBy (className = "close")
    WebElement NotiMsgCloseBtnLoc;

    @FindBy(className = "wishlist-qty")
    WebElement WishListQtyLoc;

    @FindBy(className = "ico-wishlist")
    WebElement WishListTabLoc;

    @FindBy(css = "td[class='quantity']>input")
    WebElement QtyvalueLoc;

    @FindBy(css = "button[class='button-2 add-to-wishlist-button']")
    List<WebElement> FavBtnLoc ;

    @FindBy(className = "wishlist-label")
    WebElement wishList;



    public void ClickOnFavIcon(){FavBtnLoc.get(2).click();}

    public boolean CheckSuccessMsg(){return NotiMsgLoc.isDisplayed();}
    public void CloseSuccessMsg(){ NotiMsgCloseBtnLoc.click();}
    public int GetWishListQty(){
        return ConvertString_ToInt(WishListQtyLoc.getText());
    }
    public int CheckQtyInWishListPage(){
        return Integer.parseInt(QtyvalueLoc.getAttribute("value"));
    }
    public void ClickOnWishListTab(){WishListTabLoc.click();}

    public static int ConvertString_ToInt(String text){
        String NewText =text.replaceAll("[^0-9]","");
        return Integer.parseInt(NewText);
    }
    public void ClickOnFacebook() throws InterruptedException {
        Facebook.click();
        Thread.sleep(2000);
    }
    public void ClickOnTwitter() throws InterruptedException {
        twitter.click();
        Thread.sleep(2000);
    }
    public void ClickOnRss() throws InterruptedException {
        rss.click();
        Thread.sleep(2000);
    }
    public void ClickOnYoutube() throws InterruptedException {
        youtube.click();
        Thread.sleep(2000);
    }



    public WebElement sliders(int num)
    {
        return (driver.findElement(By.xpath("//div[@id='nivo-slider']/a"+"["+num+"]")));
    }




    public void SelectCatgory(){
        Categories.get(randNum()).click();
    }

    public void HoverOnSubCategory() throws InterruptedException {
        for (int i = 0; i< SubCategories.size(); i++){
            System.out.println(SubCategories.get(i).getText());
            actions.moveToElement(SubCategories.get(i)).perform();
            Thread.sleep(5000);
        }
    }
    public int randNum(){
        Random rand = new Random();
        System.out.println(Categories.size());
        int random = rand.nextInt(Categories.size());
        return random;
    }
    public void addProductToWishList(String pro) throws InterruptedException {
        List<WebElement> products=driver.findElements(By.className("product-title"));
        List<WebElement> addBtns=driver.findElements(By.className("add-to-wishlist-button"));

        for (WebElement i: addBtns){

            if(products.get(addBtns.indexOf(i)).getText().contains(pro)){

                i.click();

                break;
            }
        }
    }
    public void goToWishlist(){
        wishList.click();
    }
    public void checkWishlist(String product) {
        List<WebElement> products = driver.findElements(By.className("product-name"));
        for (WebElement i : products) {
            if (i.isDisplayed()) {
                Assert.assertTrue(i.getText().contains(product));
                break;
            }

        }
    }





    public WebElement ClickSearchResult(){
        return Searchesult;
    }


    public void ChangeCurrency()
    {
        Select currencyMenuDrop =new Select(CustomerCurrencies);
        currencyMenuDrop.selectByVisibleText("Euro");
    }



    boolean flag ;
    public boolean CheckChangeCurrency(){
        for(int i=0; i<productPrices.size();i++)
            flag = productPrices.get(i).getText().contains("€");
        return flag;
    }


    public WebElement SearchField(){
        return SearchField;
    }
    public void ClickOnSearchBtn(){
        Searchbtn.click();
    }



}
