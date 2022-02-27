package com.tmb.tests;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseTest{

    private LoginPageTest() {
        //Make class as final so that no one should extend the class, keep constructor as private so that no one create object of the class
    }

    @Test
    public void test1() {

        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation", Keys.ENTER);
    }

    @Test
    public void test2() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing Mini Byts", Keys.ENTER);
    }
}
