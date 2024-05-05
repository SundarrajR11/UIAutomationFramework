package com.ecom.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ecom.driver.DriverFactory;

public class BasicTests {
	
	protected BasicTests() {
		
	}
	
	@BeforeMethod
	public void setUp() {
		DriverFactory.initDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}
