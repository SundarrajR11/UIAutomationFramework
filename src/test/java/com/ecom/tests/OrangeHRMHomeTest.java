package com.ecom.tests;

import com.ecom.pages.LoginPageOrangeHRM;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public final class OrangeHRMHomeTest extends BasicTests{

    private OrangeHRMHomeTest(){

    }

    @Test
    public void logoutTest(){
        LoginPageOrangeHRM loginPageOrangeHRM = new LoginPageOrangeHRM();
        String title=loginPageOrangeHRM.enterUserName("Admin").enterPassword("admin123").clickLogin()
                .clickPickerProfile().clickLogout()
                .getLoginTitle();

        Assertions.assertThat(title)
                .as("Title is not matching").isEqualTo("OrangeHRM");

    }
}
