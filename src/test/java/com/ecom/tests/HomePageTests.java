package com.ecom.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static com.ecom.driver.DriverManager.*;

public final class HomePageTests extends BasicTests {
	
	private HomePageTests() {
		
	}
	
	@Test
	public void testTwo() {
		getDriver().findElement(By.xpath("//textarea[@name='q']")).sendKeys("SDET", Keys.ENTER);
		String title=getDriver().getTitle();
		/*
		 * Assert.assertNotNull(title,"Title is null");
		 * Assert.assertTrue(title.length()>10 && title.length()<100);
		 * Assert.assertTrue(title.toLowerCase().endsWith("google search"));
		 * List<WebElement>
		 * links=DriverManager.getDriver().findElements(By.tagName("a"));
		 */
		
	
		assertThat(title)
		.as("Title is Null").isNotNull()
		.hasSizeBetween(10, 50)
		.as("Not ending with expected!").endsWith("Google Search");
		
	}

	
}
