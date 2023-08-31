package com.globalsqa.hooks;

import com.globalsqa.selenium.DriverManager;
import com.globalsqa.utils.PropertiesHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Hooks extends DriverManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hooks.class);
    private static final PropertiesHelper PH = new PropertiesHelper();

    @Before()
    public static void setUpClass(Scenario scenario) {
        LOGGER.info("--------> Before - Starting scenario: {}", scenario.getName());
        driver = initializeDriver();
        driver.get(PH.getBaseUrl());
    }

    @After()
    public void tearDown(Scenario scenario){
        LOGGER.info("--------> After - Tearing down {}", scenario.getName());
        driver.quit();
    }
}
