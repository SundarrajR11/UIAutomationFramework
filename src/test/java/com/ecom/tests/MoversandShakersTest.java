package com.ecom.tests;

import com.ecom.annotations.FrameworkAnnotations;
import com.ecom.enums.EAuthors;
import com.ecom.enums.ECategories;
import com.ecom.enums.EDevices;
import com.ecom.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class MoversandShakersTest extends BasicTests{
    private MoversandShakersTest(){

    }
    @FrameworkAnnotations(authors = EAuthors.SUNDARRAJ,categories = ECategories.REGRESSION,devices = EDevices.WEB)
    @Test(testName = "HC-2")
    public void moversandShakersTest(Map<String,String> data){

        AmazonHomePage amazonHomePage = new AmazonHomePage();
        String BannerText = amazonHomePage.
                clickHomeHamBurgerMenu()
                .clickMoverandShakers(data.get("menutext"))
                .getMoverAndShakerBanner();

        Assertions.assertThat(BannerText)
                .isEqualTo("Amazon Movers & Shakers");
    }
}
