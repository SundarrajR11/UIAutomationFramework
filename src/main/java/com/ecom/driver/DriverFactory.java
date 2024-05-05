package com.ecom.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecom.frameconstants.FrameConstants;

public final class DriverFactory {
	
	
	public static WebDriver driver;
	
	public static void initDriver() {
		if(Objects.isNull(driver)) { // driver == null
			driver=new ChromeDriver();
			driver.get(FrameConstants.getUrl());
		}
	}
	public static void quitDriver() {
		if(Objects.nonNull(driver)) {// driver != null
			driver.quit();
			driver=null;
		}
		
	}
}
