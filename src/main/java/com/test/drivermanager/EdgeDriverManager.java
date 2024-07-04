package com.test.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager extends DriverManager{
    ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
    public EdgeDriverManager() {
        WebDriverManager.edgedriver().setup();
        tlDriver.set(new EdgeDriver());
        getDriver();
    }

    public synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
