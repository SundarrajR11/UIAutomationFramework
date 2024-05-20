package com.ecom.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.frameconstants.FrameConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

public final class ExtentReport {

    private static ExtentReports extent;
    public static void initReports() throws IOException {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameConstants.getTargetPath());
            final File file=new File(FrameConstants.getSparkConfigXMLPath());
            spark.loadXMLConfig(file);
            extent.attachReporter(spark);
        }

    }
    public static void flushReports() throws URISyntaxException, IOException {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        Desktop.getDesktop().browse(new File(FrameConstants.getTargetPath()).toURI());
    }
    public static void createTests(String testcaseName){
         ReportManager.setExtentTest(extent.createTest(testcaseName));
    }
}
