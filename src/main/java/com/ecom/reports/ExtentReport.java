package com.ecom.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.constants.FrameConstants;
import com.ecom.enums.EAuthors;
import com.ecom.enums.ECategories;
import com.ecom.enums.EDevices;
import com.ecom.exceptions.InValidSparkConfigPathException;
import com.ecom.exceptions.UnableToLoadFileInBrowserException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * Utility class for managing Extent Reports.
 *
 * <p>This class provides methods for initializing, creating, and flushing Extent Reports.
 * It also supports adding authors, categories, and devices to the report entries.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * ExtentReport.initReports();
 * ExtentReport.createTests("Test Case 1", "This is a test case description");
 * ExtentReport.addAuthors(new EAuthors[]{EAuthors.SUNDARRAJ});
 * ExtentReport.addCategories(new ECategories[]{ECategories.SMOKE});
 * ExtentReport.addDevices(new EDevices[]{EDevices.WEB});
 * ExtentReport.flushReports();
 * }
 * </pre>
 */
public final class ExtentReport {

    private ExtentReport() {
        // Private constructor to prevent instantiation
    }

    private static ExtentReports extent;

    /**
     * Initializes the Extent Reports.
     *
     * <p>This method sets up the ExtentReports and ExtentSparkReporter instances. It also configures
     * the report settings using the provided spark-config.json or spark-config.xml files.</p>
     *
     * @throws InValidSparkConfigPathException if the spark configuration files cannot be loaded.
     */
    public static void initReports() {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameConstants.getTargetPath());

            try {
                ExtentSystemInfo.setSystemAndSparkReportsSetup(extent, spark);
            } catch (IOException e) {
                throw new InValidSparkConfigPathException("Please check the paths of spark-config.json/xml file!");
            }
            extent.attachReporter(spark);
        }
    }

    /**
     * Flushes the Extent Reports.
     *
     * <p>This method writes the report data to the file system and then attempts to open the report in the default web browser.</p>
     *
     * @throws UnableToLoadFileInBrowserException if the report file cannot be opened in the browser.
     */
    public static void flushReports() {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }
        ReportManager.unloadExtentTest();
        try {
            Desktop.getDesktop().browse(new File(FrameConstants.getTargetPath()).toURI());
        } catch (IOException e) {
            throw new UnableToLoadFileInBrowserException("Please verify the URL is null-free or invalid path and/or verify whether the browser supports desktop action", e);
        }
    }

    /**
     * Creates a new test in the Extent Report.
     *
     * @param testcaseName The name of the test case.
     * @param description  The description of the test case.
     */
    public static void createTests(String testcaseName, String description) {
        ReportManager.setExtentTest(extent.createTest(testcaseName, description));
    }

    /**
     * Adds authors to the current test in the Extent Report.
     *
     * @param authors An array of authors to be added.
     */
    public static void addAuthors(EAuthors[] authors) {
        for (EAuthors author : authors) {
            ReportManager.getExtentTest().assignAuthor(author.toString());
        }
    }

    /**
     * Adds categories to the current test in the Extent Report.
     *
     * @param categories An array of categories to be added.
     */
    public static void addCategories(ECategories[] categories) {
        for (ECategories category : categories) {
            ReportManager.getExtentTest().assignCategory(category.toString());
        }
    }

    /**
     * Adds devices to the current test in the Extent Report.
     *
     * @param devices An array of devices to be added.
     */
    public static void addDevices(EDevices[] devices) {
        for (EDevices device : devices) {
            ReportManager.getExtentTest().assignDevice(device.toString());
        }
    }
}