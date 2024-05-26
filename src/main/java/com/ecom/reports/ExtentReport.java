package com.ecom.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.constants.FrameConstants;
import com.ecom.enums.EAuthors;
import com.ecom.enums.ECategories;
import com.ecom.enums.EDevices;
import com.ecom.exceptions.InValidSparkConfigXMLPath;
import com.ecom.exceptions.UnableToLoadFileInBrowser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}
    private static ExtentReports extent;
    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameConstants.getTargetPath());
            String sparkConfigXMLPath=FrameConstants.getSparkConfigXMLPath();
            try {
                spark.loadXMLConfig(sparkConfigXMLPath);// it can accept both String or File
            }catch (IOException e){
                throw  new InValidSparkConfigXMLPath("Please check the provided XML file path",e);
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
            throw new UnableToLoadFileInBrowser("Please verify the url is null free or invalid path and/or verify whether browser supports desktop action",e);
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
