package com.ecom.pages;

import com.ecom.enums.EwaitStrategy;
import com.ecom.reports.ReportManager;
import com.ecom.reports.ReportsFromExtent5;
import org.openqa.selenium.By;


public class LoginPageOrangeHRM extends BasePages{


    private static final By textboxUserName =By.xpath("//input[@name='username' and @placeholder='Username']");
    private static final By textboxPassword=By.xpath("//input[@type='password' and @placeholder='Password']");

    private static final By btnLogin=By.xpath("//button[text()=' Login ']");

    public LoginPageOrangeHRM enterUserName(String username){
        sendKeys(textboxUserName,username, EwaitStrategy.VISIBLE);
        ReportManager.getExtentTest().pass("Passed");
        return this;
    }
    public LoginPageOrangeHRM enterPassword(String password){
        sendKeys(textboxPassword,password, EwaitStrategy.PRESENCE);
        ReportManager.getExtentTest().pass("Passed");
        return this;
    }
    public HomePageOrangeHRM clickLogin(){
        click(btnLogin, EwaitStrategy.CLICKABLE);
        return new HomePageOrangeHRM();
    }
    public String getLoginTitle(){
        return getPageTitle();

    }

}
