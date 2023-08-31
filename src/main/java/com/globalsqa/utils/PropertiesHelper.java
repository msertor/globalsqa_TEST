package com.globalsqa.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class PropertiesHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesHelper.class);
    private static final Properties PROPERTIES = new Properties();

    public PropertiesHelper(){
        try{
            PROPERTIES.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
        }
        catch(Exception e){
            LOGGER.error("Exception while loading config file", e);
        }
    }

    public String getBrowser(){
        return PROPERTIES.getProperty("browser");
    }

    public String getBaseUrl(){
        return PROPERTIES.getProperty("base.url");
    }

    public String getFirstName(){
        return PROPERTIES.getProperty("firstName");
    }

    public String getLastName(){
        return PROPERTIES.getProperty("lastName");
    }

    public String getPostalCode(){
        return PROPERTIES.getProperty("PostalCode");
    }

}
