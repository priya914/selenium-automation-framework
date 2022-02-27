package com.tmb.listeners;

import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import lombok.SneakyThrows;
import org.testng.*;

import java.io.IOException;
import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {


    @Override
    public void onStart(ISuite suite) {

            ExtentReport.initReports();

    }


    @Override
    public void onFinish(ISuite suite) {

            ExtentReport.flushReports();

    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() +" is passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

            ExtentLogger.fail(result.getMethod().getMethodName() +" is failed", true);
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() +" is skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
