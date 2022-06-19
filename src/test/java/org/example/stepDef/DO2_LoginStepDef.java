package org.example.stepDef;

import org.example.Page.Po2_Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class DO2_LoginStepDef {
    Po2_Login login = new Po2_Login(Hooks.driver);
    @Given("user go to login page")
    public void navigateToLoginPage(){
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
        Hooks.driver.findElement((By.className("ico-login"))).click();
    }

    @When("^user login with valid email \"(.*)\" and password \"(.*)\"$")
    public void enterValidData(String email ,String pass)
    {
        login.LoginSteps(email,pass);
    }


    @And("user press on login button")
    public void pressLoginButton(){
        login.loginbtn();
    }

    @Then("user login to the system successfully")
    public void ChekSuccess(){
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().equals("https://demo.nopcommerce.com/"));
        soft.assertTrue(Hooks.driver.findElement(By.className("ico-account")).isDisplayed());
        soft.assertAll();

    }

}
