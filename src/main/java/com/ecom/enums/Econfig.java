package com.ecom.enums;

/**
 * Enum representing configuration keys used in the application.
 *
 * <p>This enum is used to define various configuration settings for the application.
 * Each enum constant corresponds to a specific configuration key that can be used
 * to retrieve values from a configuration file or environment.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * String url = ConfigReader.getValue(Econfig.URL);
 * }
 * </pre>
 */
public enum Econfig {
	/**
	 * Represents the URL of the application to be tested.
	 */
	URL,

	/**
	 * Represents the browser type for running the tests.
	 */
	BROWSER,

	/**
	 * Represents the theme for the test reports.
	 */
	REPORT_THEME,

	/**
	 * Represents the setting to determine whether reports should be overridden.
	 */
	OVERRIDE_REPORTS,

	/**
	 * Represents the setting to capture screenshots for passed steps.
	 */
	PASSED_STEPSSCREENSHOTS,

	/**
	 * Represents the setting to capture screenshots for failed steps.
	 */
	FAILED_STEPSSCREENSHOTS,

	/**
	 * Represents the setting to capture screenshots for skipped steps.
	 */
	SKIPPED_STEPSSCREENSHOTS,

	/**
	 * Represents the setting to enable retrying failed tests.
	 */
	RETRY_FAILED_TESTS,

	/**
	 * Represents the setting for enabling cross-browser testing.
	 */
	CROSSBROWSER_TESTING
}