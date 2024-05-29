package com.ecom.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	private DriverManager(){

	}
	private static final ThreadLocal<WebDriver> driver=new ThreadLocal<>();
	
	 static void setDriver(WebDriver driverRef) {
		driver.set(driverRef);
	}
	 public static WebDriver getDriver() {
		return driver.get();
	}
	 static void unLoadDriver() {
		driver.remove();
	}
	
}
