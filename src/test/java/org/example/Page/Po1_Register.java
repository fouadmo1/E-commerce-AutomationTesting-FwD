package org.example.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Po1_Register {
    WebDriver driver;

    public Po1_Register(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "gender-male")
    WebElement male;

    @FindBy(id = "gender-female")
    WebElement female;

    @FindBy(id = "FirstName")
    WebElement FirstN;

    @FindBy(id = "LastName")
    WebElement LastN;

    @FindBy(name = "DateOfBirthDay")
    WebElement BirthDay;

    @FindBy(name = "DateOfBirthMonth")
    WebElement BirthMonth;

    @FindBy(name = "DateOfBirthYear")
    WebElement BirthYear;

    @FindBy(id = "Email")
    WebElement email ;

    @FindBy(id = "Password")
    WebElement Pass1;

    @FindBy(id = "ConfirmPassword")
    WebElement Pass2 ;
    @FindBy(id="register-button")
    WebElement regButton;

    public WebElement RegisterButton(){
        return regButton;
    }
    public WebElement GenderMale() {
        return male;
    }


    public WebElement Password1(){
        return Pass1 ;
    }
    public WebElement Password2(){
        return Pass2 ;
    }

    public WebElement GenderFemale() {
        return female;
    }

    public void FirstName(String firstname) {
        FirstN.clear();
        FirstN.sendKeys(firstname);
    }

    public void LastName(String LastName) {
        LastN.clear();
        LastN.sendKeys(LastName);
    }
    public WebElement BirthDay(){
        return BirthDay;
    }
    public WebElement BirthMonth(){
        return BirthMonth;
    }
    public WebElement BirthYear(){
        return BirthYear;
    }
    public WebElement Emaill(){
        return email;
    }
}