package com.ecom.listeners;

import com.ecom.enums.Econfig;
import com.ecom.utils.ConfigReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
    private int count =0;
    private static final int RETRIES =1;
    @Override
    public boolean retry(ITestResult result) {
        if(count< RETRIES && ConfigReader.getValue(Econfig.RETRY_FAILED_TESTS).equalsIgnoreCase("Yes")){
            count++;
            return true;
        }
        return false;
    }
}
