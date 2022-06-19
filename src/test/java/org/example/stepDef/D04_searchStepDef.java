package org.example.stepDef;

import org.example.Page.Po3_HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class D04_searchStepDef {
    Po3_HomePage home = new Po3_HomePage(Hooks.driver);

    @And("^user type the \"(.*)\" of the product on the search field$")
    public void ProductNames(String name) {
        home.SearchField().clear();
        home.SearchField().sendKeys(name);

    }

    @When("user click on search Button")
    public void ClickonSearchBtn() {
        home.ClickOnSearchBtn();
    }

    @Then("^user sees the product that he searched for \"(.*)\"$")
    public void CheckProducts(String name) {
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("search"));
        List<WebElement> products = Hooks.driver.findElements(By.xpath("//h2[@class=\"product-title\"]//a"));
        for (WebElement pro : products) {
            System.out.println(pro.getAttribute("href"));
            Assert.assertTrue(pro.getAttribute("href").contains(name));

        }
    }


}

