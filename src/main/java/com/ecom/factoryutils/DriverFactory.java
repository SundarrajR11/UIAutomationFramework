package com.ecom.factoryutils;

import com.ecom.enums.EBrowsers;
import com.ecom.exceptions.InValidBrowserEnteredException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class DriverFactory {
    private DriverFactory(){}
    public static WebDriver getDriverInstance(String browserName){
        WebDriver driver;
          if(browserName.equalsIgnoreCase(String.valueOf(EBrowsers.CHROME))) {
              driver= new ChromeDriver();
            }else if (browserName.equalsIgnoreCase(String.valueOf(EBrowsers.FIREFOX))) {
              driver= new FirefoxDriver();
            }else if (browserName.equalsIgnoreCase(String.valueOf(EBrowsers.EDGE))) {
              driver= new EdgeDriver();
            }else if (browserName.equalsIgnoreCase(String.valueOf(EBrowsers.SAFARI))) {
              driver= new SafariDriver();
            }else {
                throw new InValidBrowserEnteredException("Provided browser " + browserName + " is invalid , Retry with valid browser!");
            }
        return driver;
    }
}
