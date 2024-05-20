package com.ecom.tests;

import com.ecom.listeners.RetryFailedTests;
import com.ecom.pages.LoginPageOrangeHRM;
import com.ecom.reports.ExtentReport;
import com.ecom.utils.DataProviderLocal;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class OrangeHRMLoginTest extends BasicTests {
    private OrangeHRMLoginTest(){

    }


    @Test
    public void loginTest(Map<String,String> data){
        /*LoginPageOrangeHRM loginPageOrangeHRM = new LoginPageOrangeHRM();
        loginPageOrangeHRM.enterUserName("Admin");
        loginPageOrangeHRM.enterPassword("admin123");
        loginPageOrangeHRM.clickLogin();
        Traditional way */
        // Method chaining
        // make pages class methods to return their class instance
        LoginPageOrangeHRM loginPageOrangeHRM = new LoginPageOrangeHRM();
        String title=loginPageOrangeHRM
                .enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .getHomeTitle();
        Assertions.assertThat(title)
                .as("Title is not matching!").isEqualTo("OrangeHRM");

    }
    @Test
    public void loginTestInValid(Map<String,String> data){
        LoginPageOrangeHRM loginPageOrangeHRM = new LoginPageOrangeHRM();
        loginPageOrangeHRM.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin();
        String warning = loginPageOrangeHRM.invalidCredential();
        Assertions.assertThat(warning).
                as("Warning is not showing").
                isEqualTo("Invalid credentials");
    }
}
