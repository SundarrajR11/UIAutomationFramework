package com.ecom.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecom.constants.FrameConstants;
import com.ecom.enums.Econfig;
import com.ecom.enums.EsystemInfo;
import com.ecom.utils.ConfigReader;

import java.io.File;
import java.io.IOException;


public final class ExtentSystemInfo {
     private ExtentSystemInfo() {
    }
    public static void setSystemAndSparkReportsSetup(ExtentReports extent, ExtentSparkReporter spark) throws IOException{

        extent.setSystemInfo(String.valueOf(EsystemInfo.USER_NAME),System.getProperty("user.name"));
        extent.setSystemInfo(String.valueOf(EsystemInfo.OS_NAME),System.getProperty("os.name"));
        extent.setSystemInfo(String.valueOf(EsystemInfo.JAVA_VERSION),System.getProperty("java.version"));
        extent.setSystemInfo(String.valueOf(EsystemInfo.APP_URL),ConfigReader.getValue(Econfig.URL));


        if(ConfigReader.getValue(Econfig.REPORT_THEME).equalsIgnoreCase("Yes")){
            final File sparkConfigJsonPath=new File(FrameConstants.getSparkConfigJsonPath());
            spark.loadJSONConfig(sparkConfigJsonPath);
        }
        else {
            final File sparkConfigXMLPath=new File(FrameConstants.getSparkConfigXMLPath());
            spark.loadXMLConfig(sparkConfigXMLPath);
        }
    }
}
