package org.example.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Po2_Login {
    WebDriver driver;
    public Po2_Login(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "Email")
    WebElement Email;

    @FindBy(id = "Password")
    WebElement Pass;

    @FindBy( css= ".button-1.login-button")
    WebElement LoginBtn ;

    public void LoginSteps(String email , String pass ){
        Email.clear();
        Email.sendKeys(email);
        Pass.clear();
        Pass.sendKeys(pass);
    }

    public void loginbtn(){
        LoginBtn.click();
    }




}
