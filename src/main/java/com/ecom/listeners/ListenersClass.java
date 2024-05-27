package com.ecom.listeners;


import com.ecom.annotations.FrameworkAnnotations;
import com.ecom.enums.EAuthors;
import com.ecom.enums.ECategories;
import com.ecom.enums.EDevices;
import com.ecom.exceptions.InValidSparkConfigPathException;
import com.ecom.reports.ExtentLogger;
import com.ecom.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ListenersClass implements ITestListener, ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (IOException e) {
            throw new InValidSparkConfigPathException("Please check the paths of spark-config.json/xml file!");
        }
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
        ExtentLogger.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName()+" is Skipped!",true);
        ExtentLogger.skip(result.getThrowable().toString());
    }
}


