package com.ecom.reports;

import com.aventstack.extentreports.ExtentTest;

/**
 * Manages the {@link ExtentTest} instances for the Extent Reports framework.
 *
 * <p>This utility class provides thread-safe handling of {@link ExtentTest} instances using {@link ThreadLocal}.
 * It ensures that each thread has its own instance of {@link ExtentTest} to avoid concurrency issues.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * ExtentTest test = extent.createTest("Test Name");
 * ReportManager.setExtentTest(test);
 * ReportManager.getExtentTest().log(Status.PASS, "Test Passed");
 * ReportManager.unloadExtentTest();
 * }
 * </pre>
 */
public final class ReportManager {

    /**
     * Private constructor to prevent instantiation.
     */
    private ReportManager() {
    }

    /**
     * Thread-local variable to hold the {@link ExtentTest} instances for each thread.
     */
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    /**
     * Returns the {@link ExtentTest} instance for the current thread.
     *
     * @return the {@link ExtentTest} instance for the current thread.
     */
    static ExtentTest getExtentTest() {
        return extentTest.get();
    }

    /**
     * Sets the {@link ExtentTest} instance for the current thread.
     *
     * @param refextentTest the {@link ExtentTest} instance to be set for the current thread.
     */
    static void setExtentTest(ExtentTest refextentTest) {
        extentTest.set(refextentTest);
    }

    /**
     * Removes the {@link ExtentTest} instance for the current thread.
     */
    static void unloadExtentTest() {
        extentTest.remove();
    }
}