package com.ecom.tests;

import com.ecom.pages.LoginPageOrangeHRM;
import com.ecom.reports.ReportsFromExtent5;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;

public final class OrangeHRMHomeTest extends BasicTests{

    private OrangeHRMHomeTest(){

    }

    @Test
    public void logoutTest() throws IOException {
        LoginPageOrangeHRM loginPageOrangeHRM = new LoginPageOrangeHRM();
        //ReportsFromExtent5.createTests("TC02");
        String title=loginPageOrangeHRM.enterUserName("Admin").enterPassword("admin123").clickLogin()
                .clickPickerProfile().clickLogout()
                .getLoginTitle();
        Assertions.assertThat(title)
                .as("Title is not matching").isEqualTo("OrangeHRM");


    }
}
