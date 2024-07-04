package AppHooks;


import com.logger.Log;
import com.test.drivermanager.DriverFactory;
import com.test.drivermanager.DriverType;
import com.test.util.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class AppHooks {

    Properties properties;
    private WebDriver driver;

    @Before(order = 0)
    public void getProperty() {
        ConfigReader configReader = new ConfigReader();
        properties = configReader.init_prop();
        Log.info("Initializing properties");
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = properties.getProperty("browser");
        DriverType type = DriverType.CHROME;
        driver = DriverFactory.init_driver(type);
        Log.info("Launching browser");
    }


    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
        Log.info("Quit browser");
    }


    @After(order = 1)
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replace(" ", "_");
            byte[] image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(image,"image/png", screenshotName);
        }
    }

}
