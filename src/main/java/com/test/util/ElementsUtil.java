package com.test.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsUtil {
    private WebDriver driver;

    public ElementsUtil(WebDriver driver) {
        this.driver = driver;
    }

    public By getBy(String locatorType, String locatorValue) {
        By locator = null;

        if (locatorType.toLowerCase().trim().equals("id")) {
            locator = By.id(locatorValue);
        } else if (locatorType.toLowerCase().trim().equals("name")) {
            locator = By.name(locatorValue);
        } else if (locatorType.toLowerCase().trim().equals("classname")) {
            locator = By.className(locatorValue);
        } else if (locatorType.toLowerCase().trim().equals("xpath")) {
            locator = By.xpath(locatorValue);
        } else if (locatorType.toLowerCase().trim().equals("css")) {
            locator = By.cssSelector(locatorValue);
        } else if (locatorType.toLowerCase().trim().equals("linktext")) {
            locator = By.linkText(locatorValue);
        } else if (locatorType.toLowerCase().trim().equals("partiallinktext")) {
            locator = By.partialLinkText(locatorValue);
        } else if (locatorType.toLowerCase().trim().equals("tagname")) {
            locator = By.tagName(locatorValue);
        }

        return locator;

    }

    public WebElement doFindElement(String locator, String locatorType) {
        return driver.findElement(getBy(locator, locatorType));
    }

    public WebElement doFindElement(By locator) {
        return driver.findElement(locator);
    }

    public void doSendKeys(WebElement element, String firstName) {
        element.sendKeys(firstName);
    }

    public void enterTextInTextBox(By locator, String textToBeEntered) {
        doFindElement(locator).sendKeys(textToBeEntered);
    }

    public void doClick(By btnLocator) {
        doFindElement(btnLocator).click();
    }

    public void doClick(WebElement element) {
        element.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void enterTextInTextBox(WebElement element, String text) {
        element.sendKeys(text);
    }
}
