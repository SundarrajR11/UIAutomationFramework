package com.ecom.pages;

import com.ecom.enums.EwaitStrategy;
import com.ecom.utils.DynamicXpath;
import org.openqa.selenium.By;

public final class AmazonBestSellersPages extends  BasePages{

    private static final By BestSellersHeading= By.xpath("//span[@id='zg_banner_text']");
    private String  bestSellersBagsWalletsLuggageComPath="//*[.='Bestsellers in Bags, Wallets and Luggage']//ancestor:: div[@class='a-row a-carousel-header-row a-size-large']/following-sibling::div/descendant::div[@id='%s']/child::a";

    public String getBestSellersHeading(){
        return getText(BestSellersHeading, "BestSellersHeading");
    }
    public void clickItemBasedOnID(String itemID){
        String xpath = DynamicXpath.getXpath(bestSellersBagsWalletsLuggageComPath, itemID);
        waitAndClick(By.xpath(xpath),itemID);

    }

}
