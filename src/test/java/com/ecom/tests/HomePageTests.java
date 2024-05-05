package com.ecom.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.ecom.driver.DriverFactory;

public final class HomePageTests extends BasicTests {
	
	private HomePageTests() {
		
	}
	
	@Test
	public void testThree() {
		DriverFactory.driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("SDET", Keys.ENTER);
	}

}
