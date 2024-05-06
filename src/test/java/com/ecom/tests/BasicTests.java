package com.ecom.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ecom.driver.DriverStarterFinisher;

public class BasicTests {
	
	protected BasicTests() {
		
	}

	/*
	While deveploing frame access modifiers preferences start with private. if not protected, if not default and at last the public{least priority}
	*/
	
	@BeforeMethod
	protected void setUp() throws Exception {
		DriverStarterFinisher.initDriver();
	}
	
	@AfterMethod
	protected void tearDown() {
		DriverStarterFinisher.quitDriver();
	}

}
