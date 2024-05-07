package com.ecom.pages;

import com.ecom.driver.DriverManager;
import org.openqa.selenium.By;


public class LoginPageOrangeHRM extends BasePages{


    private static final By textboxUserName =By.xpath("//input[@name='username' and @placeholder='Username']");
    private static final By textboxPassword=By.xpath("//input[@type='password' and @placeholder='Password']");

    private static final By btnLogin=By.xpath("//button[text()=' Login ']");

    public LoginPageOrangeHRM enterUserName(String username){
        sendKeys(textboxUserName,username,"visible");
        return this;
    }
    public LoginPageOrangeHRM enterPassword(String password){
        sendKeys(textboxPassword,password,"presence");
        return this;
    }
    public HomePageOrangeHRM clickLogin(){
        click(btnLogin,"clickable");
        return new HomePageOrangeHRM();
    }
    public String getLoginTitle(){
        return getPageTitle();

    }

}
