package com.ecom.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ReportManager {
    private ReportManager(){

    }

    private static final ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();

     static ExtentTest getExtentTest() {
        return extentTest.get();
    }
     static void setExtentTest(ExtentTest refextentTest){
        extentTest.set(refextentTest);
    }
     static void unloadExtentTest(){
        extentTest.remove();
    }

}
