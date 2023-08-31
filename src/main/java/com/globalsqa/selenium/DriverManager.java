package com.globalsqa.selenium;

import com.globalsqa.utils.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DriverManager {
    public static WebDriver driver;
    private static final PropertiesHelper PH = new PropertiesHelper();

    public static WebDriver initializeDriver() {
        String browserName = PH.getBrowser();
        if (browserName.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browserName.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().deleteAllCookies();

        return driver;
    }

}
