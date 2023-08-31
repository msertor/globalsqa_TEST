package com.globalsqa.pages;

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

    public void setFirstName(String firstName){
        fnameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        lnameInput.sendKeys(lastName);
    }

    public void setPostCode(String postCode){
        pcodeInput.sendKeys(postCode);
    }

    public void fillForm(String firstName, String lastName, String postCode){
        setFirstName(firstName);
        setLastName(lastName);
        setPostCode(postCode);
    }

    public void submitForm(){
        submitBtn.click();
    }

    public boolean checkThatAlertForCustomerAddedIsPresent(){
        String alertText = driver.switchTo().alert().getText();
        return alertText.contains("Customer added successfully");
    }

}
