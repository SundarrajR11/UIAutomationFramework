package com.ecom.enums;

/**
 * Enum representing the authors of the test cases or methods.
 *
 * <p>This enum is used to specify the author of a particular test case or method,
 * helping in tracking contributions and maintaining accountability within the
 * framework.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @FrameworkAnnotations(
 *     authors = {EAuthors.SUNDARRAJ, EAuthors.MEENAKSHI},
 *     categories = {ECategories.REGRESSION},
 *     devices = {EDevices.WEB}
 * )
 * public void testMethod() {
 *     // test implementation
 * }
 * }
 * </pre>
 */
public enum EAuthors {
    /**
     * Represents Sundarraj as the author.
     */
    SUNDARRAJ,

    /**
     * Represents Devayani as the author.
     */
    DEVAYANI,

    /**
     * Represents Ragunathan as the author.
     */
    RAGUNATHAN,

    /**
     * Represents Meenakshi as the author.
     */
    MEENAKSHI
}