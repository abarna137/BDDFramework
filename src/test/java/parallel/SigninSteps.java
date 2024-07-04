package parallel;

import com.pages.AccountsOverviewPage;
import com.pages.SigninPage;
import com.test.drivermanager.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.constants.AppConstants.LAUNCH_URL;

public class SigninSteps {
    private static String title;
    private final SigninPage signinPage;

    public SigninSteps() {
       this.signinPage  = new SigninPage(DriverFactory.getDriver());
    }

    @Given("user is on home page")
    public void user_is_on_home_page() {
        DriverFactory.getDriver().get(LAUNCH_URL);
    }

    @And("user enter {string} and {string} to signin")
    public void userEnterAndToSignin(String userName, String password) {
        signinPage.enterUsernameAndPassword(userName, password);
    }

    @And("user click on Login button")
    public void user_click_on_login_button() {
        AccountsOverviewPage overviewPage = signinPage.clickLoginButton();
    }

    @Then("user gets title of the page")
    public void userGetsTitleOfThePage() {
        title = signinPage.getPageTitle();
    }

    @And("page title should be {string}")
    public void pageTitleShouldBe(String expectedPageTitle) {
        Assert.assertTrue( title.equalsIgnoreCase(expectedPageTitle),"Customer registration not successful!");
    }

}
