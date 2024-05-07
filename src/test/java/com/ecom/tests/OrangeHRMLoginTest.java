package com.ecom.tests;

import com.ecom.pages.LoginPageOrangeHRM;
import org.testng.annotations.Test;

public final class OrangeHRMLoginTest extends BasicTests {
    private OrangeHRMLoginTest(){

    }


    @Test
    public void loginTest(){
        /*LoginPageOrangeHRM loginPageOrangeHRM = new LoginPageOrangeHRM();
        loginPageOrangeHRM.enterUserName("Admin");
        loginPageOrangeHRM.enterPassword("admin123");
        loginPageOrangeHRM.clickLogin();
        Traditional way */

        // Method chaining
        // make pages class methods to return their class instance
        LoginPageOrangeHRM loginPageOrangeHRM = new LoginPageOrangeHRM();
        loginPageOrangeHRM.enterUserName("Admin").enterPassword("admin123").clickLogin().clickPickerProfile().clickLogout();
    }

}
