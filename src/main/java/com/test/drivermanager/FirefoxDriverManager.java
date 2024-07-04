package com.test.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager{
    ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    public FirefoxDriverManager() {
        WebDriverManager.firefoxdriver().setup();
        tlDriver.set(new FirefoxDriver());
        getDriver();
    }

    public synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
