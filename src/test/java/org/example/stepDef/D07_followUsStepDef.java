package org.example.stepDef;

import org.example.Page.Po3_HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {
    Po3_HomePage home = new Po3_HomePage(Hooks.driver);

    @When("User click on facebook link")
    public void FB() throws InterruptedException {
        home.ClickOnFacebook();
        ArrayList tab = new ArrayList(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(String.valueOf(tab.get(1)));
    }

    @When("User click on twitter link")
    public void twitter() throws InterruptedException {
        home.ClickOnTwitter();
        ArrayList tab = new ArrayList(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(String.valueOf(tab.get(1)));
    }

    @When("User click on rss link")
    public void Rss() throws InterruptedException {
        home.ClickOnRss();
        ArrayList tab = new ArrayList(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(String.valueOf(tab.get(1)));
    }

    @When("User click on youtube link")
    public void Youtube() throws InterruptedException {
        home.ClickOnYoutube();
        ArrayList tab = new ArrayList(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(String.valueOf(tab.get(1)));
    }

    @Then("^\"(.*)\" is opened in new tab$")
    public void Validate_Open_Social_Tab(String linkType){
        switch (linkType) {

            case "facebook":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.facebook.com/nopCommerce");
                break;

            case "twitter":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://twitter.com/nopCommerce");
                break;

            case "rss":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/new-online-store-is-open");
                break;

            case "youtube":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.youtube.com/user/nopCommerce");
                break;

        }
    }



}
