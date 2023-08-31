package com.globalsqa.pages;

import com.globalsqa.selenium.DriverManager;

public class BasePage extends DriverManager {

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
}
