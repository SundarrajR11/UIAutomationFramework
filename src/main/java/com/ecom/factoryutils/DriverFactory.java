package com.ecom.factoryutils;

import com.ecom.constants.FrameConstants;
import com.ecom.enums.EBrowsers;
import com.ecom.enums.Econfig;
import com.ecom.exceptions.FrameworkExceptions;
import com.ecom.exceptions.InValidBrowserEnteredException;
import com.ecom.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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
    private DriverFactory() {
    }

    public static WebDriver getDriverInstance(String browserName) {

        WebDriver driver;

        if (ConfigReader.getValue(Econfig.RUN_MODE).equalsIgnoreCase("remote")) {
                DesiredCapabilities caps = new DesiredCapabilities();
            if (browserName.equalsIgnoreCase("edge")) {
                caps.setBrowserName("MicrosoftEdge");
            } else {
                caps.setBrowserName(browserName.toLowerCase());
            }
            try {
                URL url=new URI(FrameConstants.getRunModeUrl()).toURL();
                driver = new RemoteWebDriver(url, caps);
            }catch (MalformedURLException |  URISyntaxException e){
                    throw new FrameworkExceptions("Malformed URL Exception Occurred!" ,e);
            }
        }
        else {
            EBrowsers eBrowsers = EBrowsers.valueOf(browserName.toUpperCase());
            switch (eBrowsers) {
                case CHROME -> driver = new ChromeDriver();
                case EDGE -> driver = new EdgeDriver();
                case FIREFOX -> driver = new FirefoxDriver();
                default -> throw new InValidBrowserEnteredException("Provided browser " + browserName + " is invalid,Retry with valid browser!");
            }
        }
        return driver;
    }
}
