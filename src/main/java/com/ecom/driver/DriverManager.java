package com.ecom.driver;

import org.openqa.selenium.WebDriver;

/**
 * Manages the WebDriver instance using ThreadLocal to ensure thread safety.
 *
 * <p>This class provides methods to set, get, and unload the WebDriver instance.
 * It uses a ThreadLocal variable to store the WebDriver instance for each thread,
 * ensuring that each thread has its own instance of WebDriver.</p>
 *
 * <p>This class is designed to be non-instantiable and all its methods are static.</p>
 */
public final class DriverManager {

	// Prevents instantiation
	private DriverManager() {

	}

	/**
	 * ThreadLocal variable to store the WebDriver instance for each thread.
	 */
	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	/**
	 * Sets the WebDriver instance for the current thread.
	 *
	 * @param driverRef the WebDriver instance to be set for the current thread.
	 */
	public static void setDriver(WebDriver driverRef) {
		driver.set(driverRef);
	}

	/**
	 * Retrieves the WebDriver instance for the current thread.
	 *
	 * @return the WebDriver instance associated with the current thread.
	 */
	public static WebDriver getDriver() {
		return driver.get();
	}

	/**
	 * Unloads the WebDriver instance for the current thread.
	 *
	 * <p>This method removes the WebDriver instance associated with the current thread,
	 * helping to avoid memory leaks and ensuring that each thread starts with a clean state.</p>
	 */
	public static void unLoadDriver() {
		driver.remove();
	}
}