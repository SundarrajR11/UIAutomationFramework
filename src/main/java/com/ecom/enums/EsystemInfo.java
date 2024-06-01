package com.ecom.enums;

/**
 * Enum representing system information keys for Extent Report dashboard.
 *
 * <p>This enum provides a list of keys for specifying system information
 * to be displayed on the Extent Report dashboard. These keys are used to
 * set system information such as the username, operating system name,
 * Java version, and application URL.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 *  extent.setSystemInfo(String.valueOf(EsystemInfo.USER_NAME),System.getProperty("user.name"));
 * extent.setSystemInfo(EsystemInfo.OS_NAME.toString(), System.getProperty("os.name"));
 * }
 * </pre>
 */
public enum EsystemInfo {
    /**
     * Key for specifying the username.
     */
    USER_NAME,
    /**
     * Key for specifying the operating system name.
     */
    OS_NAME,

    /**
     * Key for specifying the Java version.
     */
    JAVA_VERSION,

    /**
     * Key for specifying the application URL.
     */
    APP_URL
}