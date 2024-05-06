package com.ecom.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;

import com.ecom.enums.Econfig;
import com.ecom.utils.ConfigReader;

public final class DriverStarterFinisher {
	
	private DriverStarterFinisher() {
		
	}
	
	
	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {  //driver == null
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(ConfigReader.getValue(Econfig.URL));
		}
		
	}
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) { //driver != null
			DriverManager.getDriver().quit();
			DriverManager.unLoad();
		}
		
	}
}