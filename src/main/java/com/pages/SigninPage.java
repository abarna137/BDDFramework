package com.pages;

import com.test.util.ElementsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
    private final ElementsUtil util;
    private WebDriver driver;

    public SigninPage(WebDriver driver) {
        this.driver = driver;
        util = new ElementsUtil(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "username")
    private WebElement txtUsername;
    @FindBy(name = "password")
    private WebElement txtPassword;
    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement btnLogin;

    public void enterUsernameAndPassword(String userName, String password) {
        util.enterTextInTextBox(txtUsername, userName);
        util.enterTextInTextBox(txtPassword, password);
    }


    public AccountsOverviewPage clickLoginButton() {
        util.doClick(btnLogin);
        return new AccountsOverviewPage(driver);
    }

    public String getPageTitle() {
        return util.getPageTitle();
    }
}
