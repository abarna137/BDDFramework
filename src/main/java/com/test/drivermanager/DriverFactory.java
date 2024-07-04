package com.test.drivermanager;

import com.exceptions.BrowserException;
import com.logger.Log;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverFactory {
    @Getter
    public static WebDriver driver;
    public static WebDriver init_driver(DriverType browser) {
        DriverManager driverManager;
        Log.info("Launching "+browser+ " browser");
        switch (browser){
            case CHROME:
                driverManager = new ChromeDriverManager();
                driver = driverManager.getDriver();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                driver = driverManager.getDriver();
                break;
            case EDGE:
                driverManager = new EdgeDriverManager();
                driver = driverManager.getDriver();
                break;
            default:
                Log.error("Please provide valid browser details");
                throw new BrowserException("No browser found... "+browser);
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

}
