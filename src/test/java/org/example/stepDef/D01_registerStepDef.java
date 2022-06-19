package org.example.stepDef;

import org.example.Page.Po1_Register;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    Po1_Register Pregister =new Po1_Register(Hooks.driver);


    @Given("user go to register page")
    public void navigate_registerPage(){
       Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
        Hooks.driver.findElement((By.className("ico-register"))).click();
    }

    @When("user select gender")
    public void selectGender(){
        Pregister.GenderMale().click();
    }

    @And("^user enter first name \"(.*)\" and \"(.*)\" Last name$")
    public void enterName(String FirstName , String SecondName){

        Pregister.FirstName(FirstName);
        Pregister.LastName(SecondName);
    }

    @And("user enter date of birth")
    public void selectDate(){
        Select selectD = new Select(Pregister.BirthDay());
        selectD.selectByIndex(10);
        Select selectM = new Select(Pregister.BirthMonth());
        selectM.selectByVisibleText("January");
        Select selectY = new Select(Pregister.BirthYear());
        selectY.selectByVisibleText("1999");
    }

    @And("^user enter email \"(.*)\"$")
    public void enterEmail(String email){
        Pregister.Emaill().sendKeys(email);
    }


    @And("^user fills password fields \"(.*)\" and \"(.*)\"$")
    public void fillsPasswords(String password,String pass){
        Pregister.Password1().sendKeys(password);
        Pregister.Password2().sendKeys(pass);
    }


    @Then("user clicks on register button")
    public void clickregisterButton(){
        Pregister.RegisterButton().click();
    }

    @And("success message is displayed")
    public void messageDisplayed(){
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(Hooks.driver.findElement(By.className("result")).getText().contains("Your registration completed"),"success msg assertion");
        soft.assertTrue(Hooks.driver.findElement(By.className("result")).getCssValue("color").equals("rgba(76, 177, 124, 1)"));
        soft.assertAll();
    }
}
