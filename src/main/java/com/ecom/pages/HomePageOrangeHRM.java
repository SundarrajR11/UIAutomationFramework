package com.ecom.pages;

import com.ecom.enums.EwaitStrategy;
import com.ecom.reports.ReportManager;
import com.ecom.reports.ReportsFromExtent5;
import org.openqa.selenium.By;

public final class HomePageOrangeHRM extends BasePages{


    private static final By pickerProfile= By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    private static final By linkLogout=By.linkText("Logout");

    public HomePageOrangeHRM clickPickerProfile(){
        click(pickerProfile, EwaitStrategy.CLICKABLE);

        return this;
    }
    public LoginPageOrangeHRM clickLogout(){
        click(linkLogout, EwaitStrategy.CLICKABLE);

        return new LoginPageOrangeHRM();
    }
    public String getHomeTitle(){

        return getPageTitle();
    }
}
