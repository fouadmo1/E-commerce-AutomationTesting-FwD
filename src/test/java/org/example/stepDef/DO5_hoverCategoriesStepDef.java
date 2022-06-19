package org.example.stepDef;

import org.example.Page.Po3_HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DO5_hoverCategoriesStepDef {
    Po3_HomePage home = new Po3_HomePage(Hooks.driver);

    @When("user select random categories and hover on it")
    public void SelectRandomCat() throws InterruptedException {
        home.SelectCatgory();
        Thread.sleep(3000);
    }

    @Then("select random subcategories and click on it")
    public void SelectRandSubCat() throws InterruptedException {
        home.HoverOnSubCategory();

    }



}
