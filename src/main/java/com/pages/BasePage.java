package com.pages;

import com.test.util.ElementsUtil;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;

public class BasePage {
    private final ElementsUtil util;

    public BasePage(WebDriver driver) {
        util = new ElementsUtil(driver);
    }

    @SneakyThrows
    public String getPageTitle() {
        Thread.sleep(5000);
        return util.getPageTitle();
    }

}
