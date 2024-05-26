package com.ecom.listeners;


import com.ecom.annotations.FrameworkAnnotations;
import com.ecom.enums.EAuthors;
import com.ecom.enums.ECategories;
import com.ecom.enums.EDevices;
import com.ecom.exceptions.InValidSparkConfigXMLPath;
import com.ecom.reports.ExtentLogger;
import com.ecom.reports.ExtentReport;
import com.ecom.reports.ReportManager;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.Arrays;

public class ListenersClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTests(result.getMethod().getMethodName());
        EAuthors[] authors=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).authors();
        ExtentReport.addAuthors(authors);
        ECategories[] categories=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).categories();
        ExtentReport.addCategories(categories);
        EDevices[] devices=result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).devices();
        ExtentReport.addDevices(devices);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName()+" is Passed!",true);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName()+" is Failed!",true);
        ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName()+" is Skipped!",true);
        ExtentLogger.skip(result.getThrowable().toString());
    }
}


