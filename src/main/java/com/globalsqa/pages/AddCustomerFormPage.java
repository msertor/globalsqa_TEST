package com.globalsqa.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerFormPage extends ManagerPage {

    @FindBy(xpath="//input[@ng-model='fName']")
    private static WebElement fnameInput;
    @FindBy(xpath="//input[@ng-model='lName']")
    private static WebElement lnameInput;
    @FindBy(xpath="//input[@ng-model='postCd']")
    private static WebElement pcodeInput;
    @FindBy(xpath="//button[@type='submit']")
    private static WebElement submitBtn;

    public AddCustomerFormPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Entering First Name")
    public void setFirstName(String firstName){
        fnameInput.sendKeys(firstName);
    }

    @Step("Entering Last Name")
    public void setLastName(String lastName){
        lnameInput.sendKeys(lastName);
    }

    @Step("Entering Post code")
    public void setPostCode(String postCode){
        pcodeInput.sendKeys(postCode);
    }

    @Step("Filling the customer form")
    public void fillForm(String firstName, String lastName, String postCode){
        setFirstName(firstName);
        setLastName(lastName);
        setPostCode(postCode);
    }

    @Step("Submitting the form")
    public void submitForm(){
        submitBtn.click();
    }

    @Step("Checking that the confirmation when a customer is added is displayed")
    public boolean checkThatAlertForCustomerAddedIsPresent(){
        String alertText = driver.switchTo().alert().getText();
        return alertText.contains("Customer added successfully");
    }

}
