package org.example.stepDef;

import org.example.Page.Po3_HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {
    Po3_HomePage home = new Po3_HomePage(Hooks.driver);

    @Given("^User add a product \"(.*)\" to his wishlist$")
    public void addProduct(String pro) throws InterruptedException {

        home.addProductToWishList(pro);
    }

    @Then("^the product added to the wishlist and see success msg \"(.*)\"$")
    public void checkMsg(String msg) throws InterruptedException {
        SoftAssert soft=new SoftAssert();
        Thread.sleep(1000);
        soft.assertTrue(Hooks.driver.findElement(By.id("bar-notification")).getText().contains(msg),"msg");
        String color=Hooks.driver.findElement(By.xpath("/html/body/div[5]/div")).getCssValue("background-color");
        soft.assertTrue(Color.fromString(color).asHex().equals("#4bb07a"),"color");
        soft.assertAll();

    }

    @When("user open wishlist")
    public void openWishlist(){
        WebDriverWait wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(10000));
        wait.until(ExpectedConditions.invisibilityOf(Hooks.driver.findElement(By.id("bar-notification"))));
        home.goToWishlist();
    }
    @Then("^the product exist in wishlist \"(.*)\"$")
    public void checkWishlist(String p){
        home.checkWishlist(p);
    }

}
