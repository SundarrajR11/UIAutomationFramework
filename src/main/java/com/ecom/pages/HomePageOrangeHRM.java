package com.ecom.pages;

import com.ecom.driver.DriverManager;
import org.openqa.selenium.By;

public final class HomePageOrangeHRM {

    private static final By pickerProfile= By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    private static final By linkLogout=By.linkText("Logout");

    public HomePageOrangeHRM clickPickerProfile(){
        DriverManager.getDriver().findElement(pickerProfile).click();
        return this;
    }
    public LoginPageOrangeHRM clickLogout(){
        DriverManager.getDriver().findElement(linkLogout).click();
        return new LoginPageOrangeHRM();
    }
}
