package com.ecom.tests;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.ecom.driver.DriverManager;





public final class LoginPageTests extends BasicTests{
	
	private LoginPageTests() {
		
	}

	@Test
	public void testOne() {
		DriverManager.getDriver().findElement(By.xpath("//textarea[@name='q']")).sendKeys("Test Autmation Engineer", Keys.ENTER);
	}
}
