package com.globalsqa.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath="//button[text()='Bank Manager Login']")
    private static WebElement bankManagerLoginBtn;

    public LoginPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Going to the Manager Page")
    public ManagerPage pressBankManagerLogin(){
        bankManagerLoginBtn.click();
        return new ManagerPage(driver);
    }

}
