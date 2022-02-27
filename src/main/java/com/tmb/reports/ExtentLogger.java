package com.tmb.reports;

 import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;
import com.tmb.utils.ScreenshotUtils;

import java.io.IOException;

public final class ExtentLogger {

    private ExtentLogger() {}

    public static void pass(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message);
    }

    public static void pass(String message, boolean isScreenshotNeeded) {
        if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") &&
        isScreenshotNeeded) {
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        } else
            pass(message);

    }

    public static void fail(String message, boolean isScreenshotNeeded)  {
        if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") &&
                isScreenshotNeeded) {
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else
            fail(message);

    }

    public static void skip(String message, boolean isScreenshotNeeded)  {
        if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") &&
                isScreenshotNeeded) {
            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else
            skip(message);

    }

//    public static String getBase64Image() {
//
//        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
//    }
}
