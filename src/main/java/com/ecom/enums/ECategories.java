package com.ecom.enums;

/**
 * Enum representing the categories of test cases.
 *
 * <p>This enum is used to classify test cases into different categories such as
 * smoke tests, regression tests, and sanity tests. It helps in organizing and
 * filtering test cases based on their categories.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @FrameworkAnnotations(
 *     authors = {EAuthors.SUNDARRAJ},
 *     categories = {ECategories.SMOKE, ECategories.SANITY},
 *     devices = {EDevices.WEB}
 * )
 * public void testMethod() {
 *     // test implementation
 * }
 * }
 * </pre>
 */
public enum ECategories {
    /**
     * Represents smoke tests, which are a subset of tests that verify basic functionality.
     */
    SMOKE,

    /**
     * Represents regression tests, which ensure that new code changes do not adversely affect existing functionality.
     */
    REGRESSION,

    /**
     * Represents sanity tests, which are a subset of regression tests that verify specific functionality.
     */
    SANITY
}