package com.tmb.constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

import java.io.IOException;

public final class FrameworkConstants {

    private FrameworkConstants() {
        //Create private constructor so that no one can extend the class
    }

    private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String CHROMEDRIVERPATH = RESOURCESPATH+"/executables/chromedriver.exe";
    private static final String GECKODRIVERPATH = RESOURCESPATH+"/executables/geckodriver.exe";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";

    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-report";
    private static String extentReportFilePath = "";
    private static final String RUNMANGERSHEET = "RUNMANAGER";

    private static final String EXCELPATH = RESOURCESPATH+"/excel/testDataOrange.xlsx";


    public static String getExtentReportFilePath(){
        if(extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {
        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
        } else {
            return EXTENTREPORTFOLDERPATH+"/index.html";

        }
    }

    public static String getChromeDriverPath() {
        return CHROMEDRIVERPATH;
    }

    public static String getGeckodriverpath() {
        return GECKODRIVERPATH;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

    private static final int EXPLICITWAIT = 10;
    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }

    public static String getExcelpath() {
        return EXCELPATH;
    }

    public static String getRunmangerDatasheet() {
        return RUNMANGERSHEET;
    }

}
