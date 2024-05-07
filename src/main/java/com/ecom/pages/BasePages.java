package com.ecom.pages;

import com.ecom.driver.DriverManager;
import com.ecom.frameconstants.FrameConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePages {
    protected BasePages(){

    }
    protected void click(By by,String waitStrategy){
        if(waitStrategy.equalsIgnoreCase("clickable")){
            explicitWaitForElementToBeClickable(by);
        } else if (waitStrategy.equalsIgnoreCase("presence")) {
           explicitWaitForElementToBePresented(by);
        } else if (waitStrategy.equalsIgnoreCase("visible")) {
            explicitWaitForElementToBeVisible(by);
        }

        DriverManager.getDriver().findElement(by).click();
    }
    protected void sendKeys(By by,String value,String waitStrategy){
        if(waitStrategy.equalsIgnoreCase("clickable")){
            explicitWaitForElementToBeClickable(by);
        } else if (waitStrategy.equalsIgnoreCase("presence")) {
            explicitWaitForElementToBePresented(by);
        } else if (waitStrategy.equalsIgnoreCase("visible")) {
            explicitWaitForElementToBeVisible(by);
        }
        DriverManager.getDriver().findElement(by).sendKeys(value);
    }
    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }

    private void explicitWaitForElementToBeClickable(By by){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameConstants.getExplicitWait())).until(ExpectedConditions.elementToBeClickable(by));
    }
    private void explicitWaitForElementToBePresented(By by){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameConstants.getExplicitWait())).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private void explicitWaitForElementToBeVisible(By by){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameConstants.getExplicitWait())).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}
