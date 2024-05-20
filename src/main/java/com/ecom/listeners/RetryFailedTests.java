package com.ecom.listeners;

import com.ecom.enums.Econfig;
import com.ecom.utils.ConfigReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {
    int count =0;
    int retries=1;
    @Override
    public boolean retry(ITestResult result) {
        if(count<retries && ConfigReader.getValue(Econfig.RETRY_FAILED_TESTS).equalsIgnoreCase("Yes")){
            count++;
            return true;
        }
        return false;
    }
}
