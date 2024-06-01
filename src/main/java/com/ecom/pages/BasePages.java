package com.ecom.pages;

import com.ecom.driver.DriverManager;
import com.ecom.enums.EwaitStrategy;
import com.ecom.factoryutils.WaitFactory;
import com.ecom.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePages {
    protected BasePages(){

    }
    protected void waitAndClick(By by, String elementName){
        WebElement element = WaitFactory.performExplicitWait(EwaitStrategy.CLICKABLE, by);
        element.click();
        ExtentLogger.pass(elementName+" is clicked",true);
    }
    protected void waitAndSendKeys(By by, String value,String elementName){
        WebElement element = WaitFactory.performExplicitWait(EwaitStrategy.VISIBLE, by);
        element.sendKeys(value);
        ExtentLogger.pass(value+" is entered in "+ elementName,true);
    }
    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }
    protected String getText(By by, String elementName){
        WebElement element = WaitFactory.performExplicitWait(EwaitStrategy.VISIBLE, by);
        ExtentLogger.pass(elementName+"Text retrieved successfully");
        return element.getText();
    }

}
