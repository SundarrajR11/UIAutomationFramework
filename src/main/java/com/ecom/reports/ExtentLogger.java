package com.ecom.reports;


import com.aventstack.extentreports.MediaEntityBuilder;
import com.ecom.enums.Econfig;
import com.ecom.utils.ConfigReader;

import com.ecom.utils.ScreenshotTaker;

public final class ExtentLogger {
    private ExtentLogger(){}
    public static void pass(String message){
        ReportManager.getExtentTest().pass(message);
    }
    public static void pass(String message,boolean isScreenShotNeeded){
        if(ConfigReader.getValue(Econfig.PASSED_STEPSSCREENSHOTS).equalsIgnoreCase("YES")
                && isScreenShotNeeded){
            ReportManager.getExtentTest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotTaker.getBase64Screenshot()).build());
        }
        else {
            pass(message);
        }
    }
    public static void fail(String message){
        ReportManager.getExtentTest().fail(message);
    }
    public static void fail(String message,boolean isScreenShotNeeded){
        if(ConfigReader.getValue(Econfig.FAILED_STEPSSCREENSHOTS).equalsIgnoreCase("YES")
                && isScreenShotNeeded){
            ReportManager.getExtentTest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotTaker.getBase64Screenshot()).build());
        }
        else {
            fail(message);
        }
    }
    public static void skip(String message){
        ReportManager.getExtentTest().skip(message);
    }
    public static void skip(String message, boolean isScreenShotNeeded){
        if(ConfigReader.getValue(Econfig.SKIPPED_STEPSSCREENSHOTS).equalsIgnoreCase("YES")
                && isScreenShotNeeded){
            ReportManager.getExtentTest().skip(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotTaker.getBase64Screenshot()).build());
        }
        else {
            skip(message);
        }
    }
}
