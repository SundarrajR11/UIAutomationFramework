package com.ecom.pages;

import com.ecom.enums.EwaitStrategy;
import org.openqa.selenium.By;

public final class AmazonBestSellersPages extends  BasePages{

    private static final By BestSellersHeading= By.xpath("//span[@id='zg_banner_text']");

    public String getBestSellersHeading(){
        return getText(BestSellersHeading, EwaitStrategy.VISIBLE,"BestSellersHeading");
    }
}
