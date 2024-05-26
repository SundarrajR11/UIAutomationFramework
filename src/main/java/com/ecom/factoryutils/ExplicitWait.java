package com.ecom.factoryutils;

import com.ecom.enums.EwaitStrategy;
import com.ecom.constants.FrameConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.ecom.driver.DriverManager.getDriver;

public final class ExplicitWait {

    private ExplicitWait(){

    }
    public static WebElement performExplicitWait(EwaitStrategy ewaitStrategy, By by){

        switch (ewaitStrategy){
            case CLICKABLE:{
                return new WebDriverWait(getDriver(), Duration.ofSeconds(FrameConstants.getExplicitWait()))
                        .until(ExpectedConditions.elementToBeClickable(by));

            }
            case PRESENCE:{
                return new WebDriverWait(getDriver(), Duration.ofSeconds(FrameConstants.getExplicitWait()))
                        .until(ExpectedConditions.presenceOfElementLocated(by));
            }
            case VISIBLE:{
                return new WebDriverWait(getDriver(), Duration.ofSeconds(FrameConstants.getExplicitWait()))
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
            }
            case NONE:{
                return getDriver().findElement(by);
            }
            default:{
                throw new IllegalArgumentException("Unexpected value: " + ewaitStrategy);
            }
        }

    }
}
