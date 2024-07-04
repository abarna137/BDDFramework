package parallel;

import com.datagenerator.TestDataGenerator;
import com.logger.Log;
import com.pages.AccountServicesPage;
import com.pages.RegisterAccountPage;
import com.test.drivermanager.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class RegisterAccountSteps {
    private final RegisterAccountPage registerAccountPage;

    public RegisterAccountSteps() {
        this.registerAccountPage = new RegisterAccountPage(DriverFactory.getDriver());
    }

    @When("user navigate to register account page")
    public void userNavigateToRegisterAccountPage() {
        Log.info("Clicking register link to navigate to create account page");
        registerAccountPage.clickRegisterLink();
    }

    @When("user enter {string} and {string}")
    public void user_enter_and(String firstName, String lastName) {
        registerAccountPage.enterFirstName(firstName);
        registerAccountPage.enterLastName(lastName);
    }

    @When("user enters valid {string} and {string}")
    public void user_enters_valid_and(String userName, String password) {
        registerAccountPage.enterUserName(userName);
        registerAccountPage.enterPassword(password);
    }

    @And("user enters {string} {string} {string} and {string}")
    public void userEntersAnd(String address, String city, String state, String zipcode) {
        registerAccountPage.enterAddressDetails(address,city,state,zipcode);
    }

    @And("user enters {string} and {string}")
    public void userEntersAnd(String phoneNo, String ssn) {
        registerAccountPage.enterPhoneNumberAndSsn(phoneNo,ssn);
    }

    @And("user confirm password as {string}")
    public void userConfirmPasswordAs(String password) {
        registerAccountPage.confirmPassword(password);
    }


    @And("user click on Register button")
    public void userClickOnRegisterButton() {
        AccountServicesPage accountServicesPage = registerAccountPage.clickRegisterButton();
    }


    @And("user enter user details")
    public void user_enter_user_details() {
        Log.info("Entering user details..");
        registerAccountPage.enterCustomerDetails(TestDataGenerator.generateCustomerDetails());
    }
}
