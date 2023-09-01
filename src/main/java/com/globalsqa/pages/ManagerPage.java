package com.globalsqa.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage extends BasePage {

    @FindBy(xpath="//button[@ng-click='addCust()']")
    private static WebElement addCustomerBtn;
    @FindBy(xpath="//button[@ng-click='showCust()']")
    private static WebElement customersBtn;

    public ManagerPage(){
    }

    public ManagerPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Going to the Add Customer Section")
    public AddCustomerFormPage pressAddCustomerSection(){
        addCustomerBtn.click();
        return new AddCustomerFormPage(driver);
    }

    @Step("Going to the Customers Section")
    public CustomersSectionPage pressCustomersSection(){
        customersBtn.click();
        return new CustomersSectionPage(driver);
    }

}
