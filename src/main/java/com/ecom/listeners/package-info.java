/**
 * Provides classes for implementing various listeners in the application.
 * <p>
 * This package contains classes that implement TestNG listeners to perform various actions
 * during test execution in the application. Listeners are used to monitor test
 * execution and report test results.
 * </p>
 * <p>
 * The main classes in this package include:
 * <ul>
 *     <li>{@link com.ecom.listeners.ListenersClass}: Implements TestNG's {@link org.testng.ITestListener} and
 *     {@link org.testng.ISuiteListener} interfaces for listening to test and suite events
 *     and generating corresponding reports.</li>
 *     <li>{@link com.ecom.listeners.AnnotationTransformer}: Implements TestNG's {@link org.testng.IAnnotationTransformer}
 *     interface for transforming test annotations during runtime.</li>
 *     <li>{@link com.ecom.listeners.MethodInterceptor}: Implements TestNG's {@link org.testng.IMethodInterceptor} interface
 *     for intercepting test methods and performing actions before test execution.</li>
 *     <li>{@link com.ecom.listeners.RetryFailedTests}: Implements TestNG's {@link org.testng.IRetryAnalyzer} interface
 *  *     for retrying test methods based handler input when test got failed.</li>
 * </ul>
 * </p>
 */
package com.ecom.listeners;