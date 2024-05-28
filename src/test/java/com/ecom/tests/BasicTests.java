package com.ecom.tests;

import com.ecom.enums.Econfig;
import com.ecom.reports.ExtentReport;
import com.ecom.reports.ExtentSystemInfo;
import com.ecom.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.ecom.driver.DriverStarterFinisher;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Objects;

public class BasicTests {
	
	protected BasicTests() {
		
	}

	/*
	While developing framework access modifiers preferences start with private. if not protected, if not default and at last the public{the least priority}
	*/
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) throws Exception {
		if(ConfigReader.getValue(Econfig.CROSSBROWSER_TESTING).equalsIgnoreCase("yes")){
			Map<String,String> map = (Map<String,String>)data[0];
			DriverStarterFinisher.initDriver(map.get("browser"));
		}else {
			DriverStarterFinisher.initDriver(ConfigReader.getValue(Econfig.BROWSER));
		}
	}
	
	@AfterMethod
	protected void tearDown() {
		DriverStarterFinisher.quitDriver();
	}

}
