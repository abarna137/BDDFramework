package com.pages;

import com.datagenerator.CustomerDetails;
import com.test.util.ElementsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.ThreadLocalRandom;

public class RegisterAccountPage {
    private final ElementsUtil util;
    private final WebDriver driver;

    private final By lnkRegister = By.linkText("Register");
    private final By txtfirstName = By.id("customer.firstName");
    private final By txtLastName = By.id("customer.lastName");
    private final By txtAddress = By.id("customer.address.street");
    private final By txtCity = By.id("customer.address.city");
    private final By txtState = By.id("customer.address.state");
    private final By txtZipCode = By.id("customer.address.zipCode");
    private final By txtPhone = By.id("customer.phoneNumber");
    private final By txtSsn = By.id("customer.ssn");
    private final By txtUserName = By.id("customer.username");
    private final By txtPassword = By.id("customer.password");
    private final By txtConfirmPassword = By.id("repeatedPassword");
    private final By btnRegister = By.xpath("//input[@value='Register']");

    public RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
        util = new ElementsUtil(driver);
    }

    public void clickRegisterLink() { util.doClick(lnkRegister); }

    public void enterFirstName(String firstName) {
        util.enterTextInTextBox(txtfirstName, firstName);
    }

    public void enterLastName(String lastName) {
        util.enterTextInTextBox(txtLastName, lastName);
    }

    public void enterUserName(String userName) {
        util.enterTextInTextBox(txtUserName, userName);
    }

    public void enterPassword(String password) {
        util.enterTextInTextBox(txtPassword, password);
    }

    public void confirmPassword(String password) { util.enterTextInTextBox(txtConfirmPassword, password); }

    public void enterAddressDetails(String address, String city, String state, String zipcode) {
        util.enterTextInTextBox(txtAddress, address);
        util.enterTextInTextBox(txtCity, city);
        util.enterTextInTextBox(txtState, state);
        util.enterTextInTextBox(txtZipCode, zipcode);
    }

    public void enterPhoneNumberAndSsn(String phNo, String ssn) {
        util.enterTextInTextBox(txtPhone, phNo);
        util.enterTextInTextBox(txtSsn, ssn);
    }

    public AccountServicesPage clickRegisterButton() {
        util.doClick(btnRegister);
        return new AccountServicesPage(driver);
    }

    public void enterCustomerDetails(CustomerDetails customer) {
        util.enterTextInTextBox(txtfirstName, customer.getFirstName());
        util.enterTextInTextBox(txtLastName, customer.getLastName());
        util.enterTextInTextBox(txtAddress, customer.getAddressStreet());
        util.enterTextInTextBox(txtCity, customer.getAddressCity());
        util.enterTextInTextBox(txtState, customer.getAddressState());
        util.enterTextInTextBox(txtZipCode, customer.getAddressZipcode());
        util.enterTextInTextBox(txtPhone, customer.getPhoneNumber());
        util.enterTextInTextBox(txtSsn, customer.getSsnNumber());

        util.enterTextInTextBox(txtUserName, customer.getUsername());
        util.enterTextInTextBox(txtPassword, customer.getPassword());
        util.enterTextInTextBox(txtConfirmPassword, customer.getPassword());
    }
}
