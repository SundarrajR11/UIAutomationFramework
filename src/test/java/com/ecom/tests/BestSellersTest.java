package com.ecom.tests;

import com.ecom.annotations.FrameworkAnnotations;
import com.ecom.enums.EAuthors;
import com.ecom.enums.ECategories;
import com.ecom.enums.EDevices;
import com.ecom.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class BestSellersTest extends BasicTests {
    private BestSellersTest(){}

    @FrameworkAnnotations(authors = {EAuthors.SUNDARRAJ,EAuthors.MEENAKSHI,EAuthors.RAGUNATHAN,EAuthors.DEVAYANI},categories = ECategories.SANITY,devices = EDevices.MOBILE)
    @Test
    public void bestSellersTest(Map<String,String> data){
        AmazonHomePage amazonHomePage = new AmazonHomePage();
        String BestSellersHeadingText=amazonHomePage.clickHomeHamBurgerMenu()
                .clickBestSellers(data.get("menutext"))
                .getBestSellersHeading();

        Assertions.assertThat(BestSellersHeadingText)
                .isNotBlank()
                .isNotEmpty()
                .as("Heading is not Matching...").isEqualTo("Amazon Bestsellers");
    }
}
