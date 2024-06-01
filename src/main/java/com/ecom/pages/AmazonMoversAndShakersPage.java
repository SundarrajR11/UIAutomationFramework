package com.ecom.pages;

import org.openqa.selenium.By;

public class AmazonMoversAndShakersPage extends BasePages {

    private static final By moverAndShakerBanner= By.xpath("//span[@id='zg_banner_text']");

    public String getMoverAndShakerBanner(){
        return getText(moverAndShakerBanner, "Mover ans Shakers Banner");
    }
}
