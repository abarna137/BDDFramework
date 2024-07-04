package com.test.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager{

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    //todo -- check if this approach of singleton is correct
    public ChromeDriverManager() {
        if(tlDriver.get()==null) {
            WebDriverManager.chromedriver().clearDriverCache().setup();
            tlDriver.set(new ChromeDriver());
        }
        getDriver();
    }

    public synchronized WebDriver getDriver() {
        return tlDriver.get();
    }


}
