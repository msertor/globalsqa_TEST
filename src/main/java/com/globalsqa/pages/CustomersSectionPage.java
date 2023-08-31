package com.globalsqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomersSectionPage extends ManagerPage {

    @FindBy(xpath="//input[@placeholder='Search Customer']")
    private static WebElement searchCustomer;

    @FindBy(xpath="//button[@ng-click='deleteCust(cust)']")
    private static WebElement deteleCustomerBtn;

    private static final String USER_ROW = "//tr[contains(@ng-repeat,'Customers')]/td[text()='XXX']";

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomersSectionPage.class);


    public CustomersSectionPage(WebDriver driver){
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void findCustomer(String firstName) {
        searchCustomer.sendKeys(firstName);
    }

    public boolean checkIfCustomerIsFound(String firstName) {
        try{
            return driver.findElement(By.xpath(USER_ROW.replace("XXX", firstName))).isDisplayed();
        }catch (NoSuchElementException nse){
            LOGGER.info("Customer not found");
            return false;
        }
    }

    public void pressDelete(){
        deteleCustomerBtn.click();
    }

    public void deleteCustomer(String firstName){
        searchCustomer.sendKeys(firstName);
        pressDelete();
    }
}
