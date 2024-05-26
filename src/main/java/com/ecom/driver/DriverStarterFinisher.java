package com.ecom.driver;

import java.time.Duration;
import java.util.Objects;

import com.ecom.enums.EBrowsers;
import com.ecom.exceptions.InValidBrowserEnteredException;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecom.enums.Econfig;
import com.ecom.utils.ConfigReader;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.ecom.driver.DriverManager.*; // Static import done

public final class DriverStarterFinisher {
	
	private DriverStarterFinisher() {
		
	}
	
	
	public static void initDriver(String browserName){
		if(Objects.isNull(getDriver())) {  //driver == null
			if(browserName.equalsIgnoreCase(String.valueOf(EBrowsers.CHROME))){
				setDriver(new ChromeDriver());
			} else if (browserName.equalsIgnoreCase(String.valueOf(EBrowsers.FIREFOX))) {
				setDriver(new FirefoxDriver());
			} else if (browserName.equalsIgnoreCase(String.valueOf(EBrowsers.EDGE))) {
				setDriver(new EdgeDriver());
			} else if (browserName.equalsIgnoreCase(String.valueOf(EBrowsers.SAFARI))) {
				setDriver(new SafariDriver());
			}else {
				throw new InValidBrowserEnteredException("Provided browser "+browserName+" is invalid , Retry with valid browser!");
			}
			getDriver().get(ConfigReader.getValue(Econfig.URL));
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		}
		
	}
	public static void quitDriver() {
		if(Objects.nonNull(getDriver())) { //driver != null
			getDriver().quit();
			unLoadDriver();
		}
		
	}
}