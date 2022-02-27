package com.tmb.tests;

import com.tmb.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class BaseTest {

    protected BaseTest(){

        // need to keep it as protected, since it should be visible to all the class
    }



    @BeforeMethod
    protected void setUp(Object[] data) throws MalformedURLException {

        Map<String, String> map = (Map<String, String>)data[0];
        Driver.initDriver(map.get("browser"), map.get("version"));
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }

}
