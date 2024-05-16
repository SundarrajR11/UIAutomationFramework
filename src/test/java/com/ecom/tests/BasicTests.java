package com.ecom.tests;

import com.ecom.reports.ReportsFromExtent5;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import com.ecom.driver.DriverStarterFinisher;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.net.URISyntaxException;

public class BasicTests {
	
	protected BasicTests() {
		
	}

	/*
	While developing framework access modifiers preferences start with private. if not protected, if not default and at last the public{the least priority}
	*/
	@BeforeSuite
	protected void startReports() throws IOException {
		ReportsFromExtent5.initReports();
	}
	@AfterSuite
	protected void closeReports() throws URISyntaxException, IOException {
		ReportsFromExtent5.flushReports();
	}
	
	@BeforeMethod
	protected void setUp() throws Exception {
		DriverStarterFinisher.initDriver();
	}
	
	@AfterMethod
	protected void tearDown() {
		DriverStarterFinisher.quitDriver();
	}

}
