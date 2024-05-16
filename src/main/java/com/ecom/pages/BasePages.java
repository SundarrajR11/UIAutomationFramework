package com.ecom.pages;

import com.ecom.driver.DriverManager;
import com.ecom.enums.EwaitStrategy;
import com.ecom.factoryutils.ExplicitWait;
import com.ecom.frameconstants.FrameConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePages {
    protected BasePages(){

    }
    protected void click(By by, EwaitStrategy waitStrategy){
        WebElement element = ExplicitWait.performExplicitWait(waitStrategy, by);
        element.click();
    }
    protected void sendKeys(By by, String value, EwaitStrategy waitStrategy){
        WebElement element = ExplicitWait.performExplicitWait(waitStrategy, by);
        element.sendKeys(value);
    }
    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }


}
