package com.ecom.enums;

import com.ecom.driver.DriverStarterFinisher;

/**
 * Enum representing the supported web browsers for testing.
 *
 * <p>This enum is used to compare the browser name which comes from {@link DriverStarterFinisher#initDriver(String)}
 * and returns web browser instance</p>
 */
public enum EBrowsers {
    /**
     * Represents the Google Chrome browser.
     */
    CHROME,
    /**
     * Represents the Microsoft Edge browser.
     */
    EDGE,
    /**
     * Represents the Mozilla Firefox browser.
     */
    FIREFOX }
