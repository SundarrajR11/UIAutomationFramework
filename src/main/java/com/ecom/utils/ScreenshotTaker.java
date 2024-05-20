package com.ecom.utils;

import com.ecom.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotTaker {
    private ScreenshotTaker(){
    }
    public static String getBase64Screenshot(){
        return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
