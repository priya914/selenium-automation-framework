package com.tmb.pages;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentManager;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class OrangeHRMHomePage extends BasePage{

    private final By linkWelcome = By.id("welcome");
    private final By linkLogout = By.xpath("//a[text()='Logout']");


    public OrangeHRMHomePage clickWelcome() {
        click(linkWelcome, WaitStrategy.CLICKABLE, "WelcomeLink");
        ExtentLogger.pass("Welcome clicked");
        return this;
    }

    public com.tmb.pages.OrangeHRMLoginPage clickLogout() {
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        click(linkLogout, WaitStrategy.PRESENCE, "Logout Button");
        ExtentLogger.pass("Logout button clicked");
        return new OrangeHRMLoginPage();
    }


}
