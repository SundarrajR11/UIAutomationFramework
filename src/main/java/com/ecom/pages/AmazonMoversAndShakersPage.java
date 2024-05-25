package com.ecom.pages;

import com.ecom.enums.EwaitStrategy;
import org.openqa.selenium.By;

public class AmazonMoversAndShakersPage extends BasePages {

    private static final By moverAndShakerBanner= By.xpath("//span[@id='zg_banner_text']");

    public String getMoverAndShakerBanner(){
        return getText(moverAndShakerBanner, EwaitStrategy.VISIBLE,"Mover ans Shakers Banner");
    }
}
