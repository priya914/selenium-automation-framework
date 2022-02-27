package com.tmb.pages;

import com.tmb.enums.WaitStrategy;
import org.openqa.selenium.By;

public final class OrangeHRMLoginPage extends BasePage{

    private final By textBoxUsername = By.id("txtUsername");
    private final By textBoxPassword = By.id("txtPassword");
    private final By loginButton = By.id("btnLogin");

    public OrangeHRMLoginPage enterUsername(String username) {
        sendKeys(textBoxUsername,username, WaitStrategy.PRESENCE, "Username");
        return this;
    }

    public OrangeHRMLoginPage enterPassword(String password) {
        sendKeys(textBoxPassword, password, WaitStrategy.PRESENCE, "password");
        return this;
    }

    public OrangeHRMHomePage clickLogin() {
        click(loginButton, WaitStrategy.CLICKABLE, "Login button");
        return new OrangeHRMHomePage();
    }

    public String getTitle() {
        return getPageTitle();
    }
}
