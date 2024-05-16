package com.ecom.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ReportManager {
    private ReportManager(){

    }

    private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return extentTest.get();
    }
    public static void setExtentTest(ExtentTest refextentTest){
        extentTest.set(refextentTest);
    }
    public static void unloadExtentTest(){
        extentTest.remove();
    }

}
