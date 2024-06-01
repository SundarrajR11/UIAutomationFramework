package com.ecom.pages;

import org.openqa.selenium.By;

public final class AmazonHomePage extends BasePages{

    private static final By HomeHamBurgerMenu= By.xpath("//a[@id='nav-hamburger-menu']");

    public AmazonHumBugerMenuPage clickHomeHamBurgerMenu(){
        waitAndClick(HomeHamBurgerMenu, "HomeHamBurgerMenu");
        return new AmazonHumBugerMenuPage();
    }
}
