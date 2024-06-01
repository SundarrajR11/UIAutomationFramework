package com.ecom.utils;

/**
 * Utility class for generating dynamic XPath expressions.
 *
 * <p>This class provides a method to create dynamic XPath expressions by replacing
 * placeholders in a base XPath with specific values.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * String baseXpath = "//div[text()='%s']";
 * String actualXpath = DynamicXpath.getXpath(baseXpath, "ExampleText");
 * // The actualXpath will be "//div[text()='ExampleText']"
 * }
 * </pre>
 */
public final class DynamicXpath {

    /**
     * Private constructor to prevent instantiation.
     */
    private DynamicXpath() {
    }

    /**
     * Generates a dynamic XPath by replacing a placeholder in the base XPath with a specified value.
     *
     * <p>This method uses {@link String#format(String, Object...)} to replace the placeholder in the
     * base XPath (specified by '%s') with the given replacement value.</p>
     *
     * @param baseXpath the base XPath expression containing a placeholder (e.g., "//div[text()='%s']").
     * @param replaceValue the value to replace the placeholder in the base XPath.
     * @return the generated XPath with the placeholder replaced by the specified value.
     */
    public static String getXpath(String baseXpath, String replaceValue) {
        return String.format(baseXpath, replaceValue);
    }
}