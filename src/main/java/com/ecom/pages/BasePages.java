package com.ecom.pages;

import com.ecom.driver.DriverManager;
import com.ecom.enums.EwaitStrategy;
import com.ecom.factoryutils.ExplicitWait;
import com.ecom.frameconstants.FrameConstants;
import com.ecom.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePages {
    protected BasePages(){

    }
    protected void click(By by, EwaitStrategy waitStrategy,String elementName){
        WebElement element = ExplicitWait.performExplicitWait(waitStrategy, by);
        element.click();
        ExtentLogger.pass(elementName+" is clicked",true);
    }
    protected void sendKeys(By by, String value, EwaitStrategy waitStrategy,String elementName){
        WebElement element = ExplicitWait.performExplicitWait(waitStrategy, by);
        element.sendKeys(value);
        ExtentLogger.pass(value+" is entered in "+ elementName,true);
    }
    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }
    protected String getText(By by,EwaitStrategy waitStrategy, String elementName){
        WebElement element = ExplicitWait.performExplicitWait(waitStrategy, by);
        ExtentLogger.pass(elementName+"Text retrieved successfully");
        return element.getText();
    }

}
