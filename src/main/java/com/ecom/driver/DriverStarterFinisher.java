package com.ecom.driver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;

import com.ecom.factoryutils.DriverFactory;
import com.ecom.enums.Econfig;
import com.ecom.utils.ConfigReader;

import static com.ecom.driver.DriverManager.*; // Static import done

/**
 * Manages the initialization and termination of WebDriver instances.
 *
 * <p>This class provides methods to initialize and quit WebDriver instances.
 * It ensures that each thread has its own instance of WebDriver and handles
 * browser-specific configurations and settings.</p>
 *
 * <p>This class is designed to be non-instantiable and all its methods are static.</p>
 */
public final class DriverStarterFinisher {

	// Prevents instantiation
	private DriverStarterFinisher() {

	}

	/**
	 * Initializes the WebDriver instance for the specified browser.
	 *
	 * <p>If no WebDriver instance is currently associated with the current thread,
	 * this method will create a new instance using {@link DriverFactory#getDriverInstance(String)}
	 * and set it. It also navigates to the URL specified in the configuration and sets
	 * an implicit wait timeout.</p>
	 *
	 * @param browserName the name of the browser to initialize the WebDriver instance for.
	 */
	public static void initDriver(String browserName) {
		if (Objects.isNull(getDriver())) {
			setDriver(DriverFactory.getDriverInstance(browserName));
		}
		getDriver().get(ConfigReader.getValue(Econfig.URL));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	/**
	 * Quits the WebDriver instance for the current thread.
	 *
	 * <p>If a WebDriver instance is currently associated with the current thread,
	 * this method will quit the instance and unload it from the {@link DriverManager}.</p>
	 */
	public static void quitDriver() {
		if (Objects.nonNull(getDriver())) { // driver != null
			getDriver().quit();
			unLoadDriver();
		}
	}
}