package com.ecom.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.constants.FrameConstants;
import com.ecom.enums.Econfig;
import com.ecom.enums.EsystemInfo;
import com.ecom.utils.ConfigReader;

import java.io.File;
import java.io.IOException;

/**
 * Utility class for setting up system and Spark report configurations for Extent Reports.
 *
 * <p>This class provides methods to configure system information and load Spark report configuration
 * files (JSON or XML) based on user preferences.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * ExtentReports extent = new ExtentReports();
 * ExtentSparkReporter spark = new ExtentSparkReporter("path/to/report");
 * ExtentSystemInfo.setSystemAndSparkReportsSetup(extent, spark);
 * }
 * </pre>
 */
public final class ExtentSystemInfo {

    /**
     * Private constructor to prevent instantiation.
     */
    private ExtentSystemInfo() {
    }

    /**
     * Sets system information and Spark report configuration for Extent Reports.
     *
     * <p>This method configures the Extent Reports with system information such as user name, OS name,
     * Java version, and application URL. It also loads the Spark report configuration file (JSON or XML)
     * based on the user's configuration preference.</p>
     *
     * @param extent the {@link ExtentReports} instance to be configured.
     * @param spark the {@link ExtentSparkReporter} instance to be configured.
     * @throws IOException if an I/O error occurs while loading the Spark configuration file.
     */
    public static void setSystemAndSparkReportsSetup(ExtentReports extent, ExtentSparkReporter spark) throws IOException {

        extent.setSystemInfo(String.valueOf(EsystemInfo.USER_NAME), System.getProperty("user.name"));
        extent.setSystemInfo(String.valueOf(EsystemInfo.OS_NAME), System.getProperty("os.name"));
        extent.setSystemInfo(String.valueOf(EsystemInfo.JAVA_VERSION), System.getProperty("java.version"));
        extent.setSystemInfo(String.valueOf(EsystemInfo.APP_URL), ConfigReader.getValue(Econfig.URL));

        if (ConfigReader.getValue(Econfig.REPORT_THEME).equalsIgnoreCase("Yes")) {
            final File sparkConfigJsonPath = new File(FrameConstants.getSparkConfigJsonPath());
            spark.loadJSONConfig(sparkConfigJsonPath);
        } else {
            final File sparkConfigXMLPath = new File(FrameConstants.getSparkConfigXMLPath());
            spark.loadXMLConfig(sparkConfigXMLPath);
        }
    }
}