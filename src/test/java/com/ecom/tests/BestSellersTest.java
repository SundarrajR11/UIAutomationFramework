package com.ecom.tests;

import com.ecom.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class BestSellersTest extends BasicTests {
    private BestSellersTest(){}

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
