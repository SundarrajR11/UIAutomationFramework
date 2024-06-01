package com.ecom.utils;

import com.ecom.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * ScreenShotTaker class for taking screenshots in Base64 format.
 *
 * <p>This class provides a method to capture a screenshot of the current browser window
 * and return it as a Base64 encoded string. This can be useful for embedding screenshots
 * in reports or logs.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * String screenshot = ScreenshotTaker.getBase64Screenshot();
 * }
 * </pre>
 */
public final class ScreenshotTaker {

    /**
     * Private constructor to prevent instantiation.
     */
    private ScreenshotTaker() {
    }

    /**
     * Captures a screenshot of the current browser window and returns it as a Base64 encoded string.
     *
     * <p>This method uses the {@link TakesScreenshot} interface to capture the screenshot and
     * return it in Base64 format. It retrieves the current driver instance from the
     * {@link DriverManager}.</p>
     *
     * @return a Base64 encoded string representing the screenshot.
     */
    public static String getBase64Screenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}