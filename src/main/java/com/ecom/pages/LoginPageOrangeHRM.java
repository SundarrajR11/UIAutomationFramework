package com.ecom.pages;

import com.ecom.driver.DriverManager;
import com.ecom.enums.EwaitStrategy;
import org.openqa.selenium.By;


public class LoginPageOrangeHRM extends BasePages{


    private static final By textboxUserName =By.xpath("//input[@name='username' and @placeholder='Username']");
    private static final By textboxPassword=By.xpath("//input[@type='password' and @placeholder='Password']");

    private static final By btnLogin=By.xpath("//button[text()=' Login ']");

    private static final By invalidCredentials=By.xpath("//*[@role='alert']//descendant::p[.='Invalid credentials']");

    public LoginPageOrangeHRM enterUserName(String username){
        sendKeys(textboxUserName,username, EwaitStrategy.VISIBLE,"Username");
        return this;
    }
    public LoginPageOrangeHRM enterPassword(String password){
        sendKeys(textboxPassword,password, EwaitStrategy.PRESENCE,"Password");
        return this;
    }
    public HomePageOrangeHRM clickLogin(){
        click(btnLogin, EwaitStrategy.CLICKABLE,"Login Button");
        return new HomePageOrangeHRM();
    }
    public String getLoginTitle(){
        return getPageTitle();

    }
    public String invalidCredential(){
        return DriverManager.getDriver().findElement(invalidCredentials).getText();
    }
}
