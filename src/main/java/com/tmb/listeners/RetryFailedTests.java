package com.tmb.listeners;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;

    @Override
    public boolean retry(ITestResult result) {
        boolean value = false;


            if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {

                int retires = 1;
                value = count < retires;
                count++;
            }


        return value;
    }
}
