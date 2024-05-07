package com.ecom.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	private DriverManager(){

	}
	private static final ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	public static void setDriver(WebDriver driverRef) {
		driver.set(driverRef);
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void unLoad() {
		driver.remove();
	}
	
}
