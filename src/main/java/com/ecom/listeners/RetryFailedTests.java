package com.ecom.listeners;

import com.ecom.enums.Econfig;
import com.ecom.utils.ConfigReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Retry analyzer for TestNG to retry failed tests.
 *
 * <p>This class implements the {@link IRetryAnalyzer} interface to provide custom logic
 * for retrying failed tests. The number of retries and whether to retry is controlled by
 * the configuration settings.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @Listeners(RetryFailedTests.class)
 * public class YourTestClass {
 *     // Test methods...
 * }
 * }
 * </pre>
 */
public class RetryFailedTests implements IRetryAnalyzer {

    private int count = 0;
    private static final int RETRIES = 1;

    /**
     * Determines whether the test method should be retried.
     *
     * @param result the result of the test method that was executed.
     * @return {@code true} if the test method should be retried, {@code false} otherwise.
     */
    @Override
    public boolean retry(ITestResult result) {
        if (count < RETRIES && ConfigReader.getValue(Econfig.RETRY_FAILED_TESTS).equalsIgnoreCase("Yes")) {
            count++;
            return true;
        }
        return false;
    }
}