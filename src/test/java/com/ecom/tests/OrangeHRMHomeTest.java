package com.ecom.tests;

import com.ecom.pages.LoginPageOrangeHRM;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;

public final class OrangeHRMHomeTest extends BasicTests{

    private OrangeHRMHomeTest(){

    }

    @Test(testName = "HC-21_TC02")
    public void logoutTest() throws IOException {
        LoginPageOrangeHRM loginPageOrangeHRM = new LoginPageOrangeHRM();
        //ExtentReport.createTests("TC02");
        String title=loginPageOrangeHRM.enterUserName("Admin").enterPassword("admin123").clickLogin()
                .clickPickerProfile().clickLogout()
                .getLoginTitle();
        Assertions.assertThat(title)
                .as("Title is not matching").isEqualTo("OrangeHRM");


    }
}
