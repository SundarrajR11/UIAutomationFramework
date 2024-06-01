package com.ecom.listeners;

import com.ecom.annotations.FrameworkAnnotations;
import com.ecom.enums.EAuthors;
import com.ecom.enums.ECategories;
import com.ecom.enums.EDevices;
import com.ecom.reports.ExtentLogger;
import com.ecom.reports.ExtentReport;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Custom TestNG listener class for logging and reporting test results.
 *
 * <p>This class implements {@link ITestListener} and {@link ISuiteListener} to provide
 * custom actions for test start, success, failure, and skipping, as well as suite start and finish.</p>
 *
 * <p>The class integrates with ExtentReports for logging and reporting the test results,
 * and it retrieves custom annotations to add metadata to the reports.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @Listeners(ListenersClass.class)
 * public class YourTestClass {
 *     // Test methods...
 * }
 * }
 * </pre>
 */
public class ListenersClass implements ITestListener, ISuiteListener {

    /**
     * Invoked before the suite starts.
     *
     * @param suite the suite that is about to start.
     */
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
    }

    /**
     * Invoked after the suite finishes.
     *
     * @param suite the suite that has just finished.
     */
    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
    }

    /**
     * Invoked before a test starts.
     *
     * @param result the result of the test method that is about to start.
     */
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReport.createTests(result.getMethod().getMethodName(), result.getMethod().getDescription());
        EAuthors[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).authors();
        ExtentReport.addAuthors(authors);
        ECategories[] categories = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).categories();
        ExtentReport.addCategories(categories);
        EDevices[] devices = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).devices();
        ExtentReport.addDevices(devices);
    }

    /**
     * Invoked when a test succeeds.
     *
     * @param result the result of the test method that has just succeeded.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getMethod().getMethodName() + " is Passed!", true);
    }

    /**
     * Invoked when a test fails.
     *
     * @param result the result of the test method that has just failed.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(result.getMethod().getMethodName() + " is Failed!", true);
        ExtentLogger.fail(result.getThrowable());
    }

    /**
     * Invoked when a test is skipped.
     *
     * @param result the result of the test method that has just been skipped.
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getMethod().getMethodName() + " is Skipped!", true);
        ExtentLogger.skip(result.getThrowable().toString());
    }
}