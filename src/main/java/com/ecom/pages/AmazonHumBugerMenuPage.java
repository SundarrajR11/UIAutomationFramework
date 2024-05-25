package com.ecom.pages;

import com.ecom.enums.EwaitStrategy;
import com.ecom.factoryutils.DynamicXpath;
import org.openqa.selenium.By;

public final class AmazonHumBugerMenuPage extends BasePages{

    /*
    * Under a tag pass value which present there in html tag*/
    private static final String CommonXpath= "//div[@id='hmenu-content']//descendant::a[.='%s']";

    public AmazonBestSellersPages clickBestSellers(String menuText){
        String bestSellersXpath= DynamicXpath.getXpath(CommonXpath,menuText);
        click(By.xpath(bestSellersXpath), EwaitStrategy.CLICKABLE,"Best Sellers");
        return new AmazonBestSellersPages();
    }
    public AmazonNewReleasesPage clickNewRelease(String menuText){
        String newReleaseXpath = DynamicXpath.getXpath(CommonXpath,menuText);
        click(By.xpath(newReleaseXpath),EwaitStrategy.CLICKABLE,"New Releases");
        return new AmazonNewReleasesPage();
    }
    public AmazonMoversAndShakersPage clickMoverandShakers(String menuText){
        String newReleaseXpath = DynamicXpath.getXpath(CommonXpath,menuText);
        click(By.xpath(newReleaseXpath),EwaitStrategy.CLICKABLE,"Movers and Shakers");
        return new AmazonMoversAndShakersPage();
    }
}
