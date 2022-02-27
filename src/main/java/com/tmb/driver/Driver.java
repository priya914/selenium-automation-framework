package com.tmb.driver;

import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;
import com.tmb.exceptions.BrowserInvocationFailedException;
import com.tmb.factories.DriverFactory;
import com.tmb.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver() {

    }

    public static void initDriver(String browser, String version) throws MalformedURLException {
//        String runmode = "Remote";
//        if(Objects.isNull(DriverManager.getDriver())) {
//            if(browser.equalsIgnoreCase("chrome")) {
//
////                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
//                WebDriverManager.chromedriver().setup();
//                if(runmode.equalsIgnoreCase("Remote")){
//                    DesiredCapabilities cap = new DesiredCapabilities();
//                    cap.setBrowserName(BrowserType.CHROME);
//                }
//                DriverManager.setDriver(new ChromeDriver());
//            } else if(browser.equalsIgnoreCase("firefox")) {
////                System.setProperty("webdriver.gecko.driver", FrameworkConstants.getGeckodriverpath());
//                WebDriverManager.firefoxdriver().setup();
//                DriverManager.setDriver(new FirefoxDriver());
//
//
//
//            }
        if(Objects.isNull(DriverManager.getDriver())) {
            DriverManager.setDriver(DriverFactory.getDriver(browser,version));

            DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }


    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
