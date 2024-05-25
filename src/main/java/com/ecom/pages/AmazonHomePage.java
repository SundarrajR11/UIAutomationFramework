package com.ecom.pages;

import com.ecom.enums.EwaitStrategy;
import org.openqa.selenium.By;

public final class AmazonHomePage extends BasePages{

    private static final By HomeHamBurgerMenu= By.xpath("//a[@id='nav-hamburger-menu']");

    public AmazonHumBugerMenuPage clickHomeHamBurgerMenu(){
        click(HomeHamBurgerMenu, EwaitStrategy.CLICKABLE,"HomeHamBurgerMenu");
        return new AmazonHumBugerMenuPage();
    }
}
