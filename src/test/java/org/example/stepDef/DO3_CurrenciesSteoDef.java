package org.example.stepDef;

import org.example.Page.Po2_Login;
import org.example.Page.Po3_HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class DO3_CurrenciesSteoDef {
    Po3_HomePage home = new Po3_HomePage(Hooks.driver);

    @Given("user login successfully")
    public void userLogin()
    {
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
        Hooks.driver.findElement((By.className("ico-login"))).click();
        Po2_Login login = new Po2_Login(Hooks.driver);
        login.LoginSteps("fouadmohamed8@gmail.com","123456");
        login.loginbtn();
    }
    @When("user click on the droplist on the topleft and choose euro")
    public void uesrChangeCurrencies(){
        home.ChangeCurrency();
    }
    @Then("all currencies changed to '€'")
    public void Check(){
        Assert.assertTrue(home.CheckChangeCurrency());
    }

}
