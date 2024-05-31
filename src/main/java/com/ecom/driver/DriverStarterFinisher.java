package com.ecom.driver;

import java.time.Duration;
import java.util.Objects;

import com.ecom.factoryutils.DriverFactory;

import com.ecom.enums.Econfig;
import com.ecom.utils.ConfigReader;

import static com.ecom.driver.DriverManager.*; // Static import done

public final class DriverStarterFinisher {

	private DriverStarterFinisher() {

	}

	public static void initDriver(String browserName){
		if(Objects.isNull(getDriver())){
			setDriver(DriverFactory.getDriverInstance(browserName));
		}
		getDriver().get(ConfigReader.getValue(Econfig.URL));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}

	public static void quitDriver() {
		if(Objects.nonNull(getDriver())) { //driver != null
			getDriver().quit();
			unLoadDriver();
		}
		
	}
}