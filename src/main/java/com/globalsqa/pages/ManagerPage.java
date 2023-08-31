package com.globalsqa.pages;


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

    public AddCustomerFormPage pressAddCustomerSection(){
        addCustomerBtn.click();
        return new AddCustomerFormPage(driver);
    }

    public CustomersSectionPage pressCustomersSection(){
        customersBtn.click();
        return new CustomersSectionPage(driver);
    }

}
