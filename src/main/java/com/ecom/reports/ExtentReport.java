package com.ecom.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.constants.FrameConstants;
import com.ecom.enums.EAuthors;
import com.ecom.enums.ECategories;
import com.ecom.enums.EDevices;
import com.ecom.enums.Econfig;
import com.ecom.exceptions.UnableToLoadFileInBrowserException;
import com.ecom.utils.ConfigReader;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}
    private static ExtentReports extent;
    public static void initReports() throws IOException {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameConstants.getTargetPath());

            if(ConfigReader.getValue(Econfig.REPORT_THEME).equalsIgnoreCase("Yes")){
                final File sparkConfigJsonPath=new File(FrameConstants.getSparkConfigJsonPath());
                spark.loadJSONConfig(sparkConfigJsonPath);
            }
            else {
                final File sparkConfigXMLPath=new File(FrameConstants.getSparkConfigXMLPath());
                spark.loadXMLConfig(sparkConfigXMLPath);
            }
            extent.attachReporter(spark);
        }

    }
    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ReportManager.unloadExtentTest();
        try {
            Desktop.getDesktop().browse(new File(FrameConstants.getTargetPath()).toURI());
        } catch (IOException e) {
            throw new UnableToLoadFileInBrowserException("Please verify the url is null free or invalid path and/or verify whether browser supports desktop action",e);
        }
    }
    public static void createTests(String testcaseName){
         ReportManager.setExtentTest(extent.createTest(testcaseName));
    }

    public static void addAuthors(EAuthors[] authors){
        for (EAuthors author: authors) {
            ReportManager.getExtentTest().assignAuthor(author.toString());
        }
    }
    public static void addCategories(ECategories[] categories){
        for (ECategories category : categories){
            ReportManager.getExtentTest().assignCategory(category.toString());
        }
    }
    public static void addDevices(EDevices[] devices){
        for (EDevices device : devices){
            ReportManager.getExtentTest().assignDevice(device.toString());
        }
    }
}
