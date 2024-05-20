package com.ecom.tests;

import com.ecom.listeners.RetryFailedTests;
import com.ecom.pages.LoginPageOrangeHRM;
import com.ecom.utils.DataProviderLocal;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public final class OrangeHRMHomeTest extends BasicTests{

    private OrangeHRMHomeTest(){

    }

    @Test
    public void logoutTest(Map<String,String> data) throws IOException {
        LoginPageOrangeHRM loginPageOrangeHRM = new LoginPageOrangeHRM();
        String title=loginPageOrangeHRM.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
                .clickPickerProfile().clickLogout()
                .getLoginTitle();
        Assertions.assertThat(title)
                .as("Title is not matching").isEqualTo("OrangeHRM");


    }
}
