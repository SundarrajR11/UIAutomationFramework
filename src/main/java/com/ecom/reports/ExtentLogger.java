/**
 * Provides classes for generating and managing reports.
 */
package com.ecom.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.ecom.enums.Econfig;
import com.ecom.utils.ConfigReader;
import com.ecom.utils.ScreenshotTaker;

/**
 * ExtentLogger class for logging messages to the Extent Reports.
 *
 * <p>This class provides methods for logging different statuses (pass, fail, skip) to the Extent Reports.
 * It also supports capturing screenshots for the log entries if configured to do so.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * ExtentLogger.pass("Test passed successfully");
 * ExtentLogger.fail("Test failed", true);
 * ExtentLogger.skip("Test skipped", false);
 * }
 * </pre>
 */
public final class ExtentLogger {

    private ExtentLogger() {
        // Private constructor to prevent instantiation
    }

    /**
     * Logs a passing status with a message.
     *
     * @param message The message to log.
     */
    public static void pass(String message) {
        ReportManager.getExtentTest().pass(message);
    }

    /**
     * Logs a passing status with a message and an optional screenshot.
     *
     * @param message The message to log.
     * @param isScreenShotNeeded Whether a screenshot is needed.
     */
    public static void pass(String message, boolean isScreenShotNeeded) {
        if (ConfigReader.getValue(Econfig.PASSED_STEPSSCREENSHOTS).equalsIgnoreCase("YES")
                && isScreenShotNeeded) {
            ReportManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotTaker.getBase64Screenshot()).build());
        } else {
            pass(message);
        }
    }

    /**
     * Logs a failing status with a message.
     *
     * @param message The message to log.
     */
    public static void fail(String message) {
        ReportManager.getExtentTest().fail(message);
    }

    /**
     * Logs a failing status with a throwable cause.
     *
     * @param cause The throwable cause to log.
     */
    public static void fail(Throwable cause) {
        ReportManager.getExtentTest().fail(cause);
    }

    /**
     * Logs a failing status with a message and an optional screenshot.
     *
     * @param message The message to log.
     * @param isScreenShotNeeded Whether a screenshot is needed.
     */
    public static void fail(String message, boolean isScreenShotNeeded) {
        if (ConfigReader.getValue(Econfig.FAILED_STEPSSCREENSHOTS).equalsIgnoreCase("YES")
                && isScreenShotNeeded) {
            ReportManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotTaker.getBase64Screenshot()).build());
        } else {
            fail(message);
        }
    }

    /**
     * Logs a skipped status with a message.
     *
     * @param message The message to log.
     */
    public static void skip(String message) {
        ReportManager.getExtentTest().skip(message);
    }

    /**
     * Logs a skipped status with a message and an optional screenshot.
     *
     * @param message The message to log.
     * @param isScreenShotNeeded Whether a screenshot is needed.
     */
    public static void skip(String message, boolean isScreenShotNeeded) {
        if (ConfigReader.getValue(Econfig.SKIPPED_STEPSSCREENSHOTS).equalsIgnoreCase("YES")
                && isScreenShotNeeded) {
            ReportManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotTaker.getBase64Screenshot()).build());
        } else {
            skip(message);
        }
    }
}