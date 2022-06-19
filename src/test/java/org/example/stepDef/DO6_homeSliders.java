package org.example.stepDef;

import org.example.Page.Po3_HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DO6_homeSliders {
Po3_HomePage home = new Po3_HomePage(Hooks.driver);
    @When("user click on first home slider")
    public void ClickOnFirstSlider(){
        home.sliders(1).click();
    }
    @When("user click on sub home slider")
    public void ClickOnSubSlider(){
        home.sliders(2);
    }
    @Then("^System should direct user to nokia-lumia URL \"(.*)\"$")
    public void FirstsliderCheck(String nokiaUrl){
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        boolean flag =  wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/nokia-lumia-1020"));
        Assert.assertTrue(flag);
    }
    @Then("^System should direct user to Iphone-6 URL \"(.*)\"$")
    public void SecondSliderCheck(String iphoneUrl)
    {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        boolean flag =  wait.until(ExpectedConditions.urlContains("https://demo.nopcommerce.com/iphone-6"));
        Assert.assertTrue(flag);
    }
}
