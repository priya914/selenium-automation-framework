package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private ExtentManager() {}

    private  static final ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

     static ExtentTest getExtentTest() {
        return extTest.get();
    }

    /**
     *
     * @param test
     */
     static  void setExtentTest(ExtentTest test) {
        extTest.set(test);
    }

     static void unload() {
        extTest.remove();
    }
}
