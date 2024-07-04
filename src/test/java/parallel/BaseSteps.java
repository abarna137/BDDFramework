package parallel;

import com.pages.BasePage;
import com.test.drivermanager.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.constants.AppConstants.LAUNCH_URL;

public class BaseSteps {
    private final BasePage basePage;
    private static String title;

    public BaseSteps(){
        this.basePage = new BasePage(DriverFactory.getDriver());
    }
    @Given("user is on home page")
    public void user_is_on_home_page() {
        DriverFactory.getDriver().get(LAUNCH_URL);
    }

    @And("page title should be {string}")
    public void pageTitleShouldBe(String expectedPageTitle) {
        Assert.assertTrue("Customer registration not successful!", title.equalsIgnoreCase(expectedPageTitle));
    }

    @SneakyThrows
    @Then("user gets title of the page")
    public void userGetsTitleOfThePage() {
        title = basePage.getPageTitle();
    }
}
