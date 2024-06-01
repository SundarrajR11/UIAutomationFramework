package com.ecom.enums;

/**
 * Enum representing the types of devices on which tests can be executed.
 *
 * <p>This enum is used to specify the target devices for test cases, such as web browsers,
 * mobile devices, and desktop applications. It helps in organizing and filtering test cases
 * based on the devices they are intended to run on.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @FrameworkAnnotations(
 *     authors = {EAuthors.SUNDARRAJ},
 *     categories = {ECategories.REGRESSION},
 *     devices = {EDevices.WEB, EDevices.MOBILE}
 * )
 * public void testMethod() {
 *     // test implementation
 * }
 * }
 * </pre>
 */
public enum EDevices {
    /**
     * Represents web browsers as the target device for testing.
     */
    WEB,

    /**
     * Represents mobile devices as the target device for testing.
     */
    MOBILE,

    /**
     * Represents desktop applications as the target device for testing.
     */
    DESKTOP
}