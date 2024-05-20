package com.ecom.pages;

import com.ecom.enums.EwaitStrategy;
import org.openqa.selenium.By;

public final class HomePageOrangeHRM extends BasePages{


    private static final By pickerProfile= By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    private static final By linkLogout=By.linkText("Logout");

    public HomePageOrangeHRM clickPickerProfile(){
        click(pickerProfile, EwaitStrategy.CLICKABLE,"Profile Picker");
        return this;
    }
    public LoginPageOrangeHRM clickLogout(){
        click(linkLogout, EwaitStrategy.CLICKABLE,"Logout Link");
        return new LoginPageOrangeHRM();
    }
    public String getHomeTitle(){
        return getPageTitle();
    }
}
