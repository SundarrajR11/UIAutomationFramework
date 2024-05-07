package com.ecom.pages;

import com.ecom.driver.DriverManager;
import org.openqa.selenium.By;

public class LoginPageOrangeHRM {


    private static final By textboxUserName =By.xpath("//input[@name='username' and @placeholder='Username']");
    private static final By textboxPassword=By.xpath("//input[@type='password' and @placeholder='Password']");

    private static final By btnLogin=By.xpath("//button[text()=' Login ']");

    public LoginPageOrangeHRM enterUserName(String username){
        DriverManager.getDriver().findElement(textboxUserName).sendKeys(username);
        return this;
    }
    public LoginPageOrangeHRM enterPassword(String password){
        DriverManager.getDriver().findElement(textboxPassword).sendKeys(password);
        return this;
    }
    public HomePageOrangeHRM clickLogin(){
        DriverManager.getDriver().findElement(btnLogin).click();
        return new HomePageOrangeHRM();
    }

}
