package com.globalsqa.pages;

import com.globalsqa.selenium.DriverManager;
import io.qameta.allure.Step;

public class BasePage extends DriverManager {

    @Step("Dismissing alert")
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
}
