package com.ecom.factoryutils;

import com.ecom.enums.EBrowsers;
import com.ecom.exceptions.InValidBrowserEnteredException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Factory class for creating WebDriver instances based on browser type.
 *
 * <p>This class provides a factory method to create instances of WebDriver
 * based on the specified browser name. It supports Chrome, Firefox, Edge, and Safari browsers.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * WebDriver driver = DriverFactory.getDriverInstance("chrome");
 * }
 * </pre>
 */
public final class DriverFactory {
    private DriverFactory() {}

    /**
     * Creates a new instance of WebDriver based on the specified browser name.
     *
     * @param browserName the name of the browser (e.g., "chrome", "firefox", "edge", "safari").
     * @return a new instance of WebDriver corresponding to the specified browser.
     * @throws InValidBrowserEnteredException if an invalid browser name is provided.
     */
    public static WebDriver getDriverInstance(String browserName) {
        WebDriver driver;
        if (browserName.equalsIgnoreCase(String.valueOf(EBrowsers.CHROME))) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase(String.valueOf(EBrowsers.FIREFOX))) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase(String.valueOf(EBrowsers.EDGE))) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase(String.valueOf(EBrowsers.SAFARI))) {
            driver = new SafariDriver();
        } else {
            throw new InValidBrowserEnteredException("Provided browser " + browserName + " is invalid,Retry with valid browser!");
        }
        return driver;
    }
}