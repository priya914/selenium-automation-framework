package com.tmb.pages;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class BasePage {
    protected void click(By by, WaitStrategy waitStrategy, String elementName) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        ExtentLogger.pass(elementName +" is clicked ", true);
        element.click();
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
        WebElement element = DriverManager.getDriver().findElement(by);
        element.sendKeys(value);
        ExtentLogger.pass(value+" is entered successfully in "+elementName, true);
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
