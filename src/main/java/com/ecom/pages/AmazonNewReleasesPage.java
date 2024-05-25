package com.ecom.pages;

import com.ecom.enums.EwaitStrategy;
import org.openqa.selenium.By;

public final class AmazonNewReleasesPage extends BasePages{

    private static final By newReleasesHeading= By.xpath("//span[@id='zg_banner_text']");

    public String getNewReleasesHeading(){
       return getText(newReleasesHeading, EwaitStrategy.VISIBLE,"New Release Heading");
    }

}
