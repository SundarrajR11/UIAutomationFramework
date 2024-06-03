package com.ecom.tests;

import com.ecom.annotations.FrameworkAnnotations;
import com.ecom.enums.EAuthors;
import com.ecom.enums.ECategories;
import com.ecom.enums.EDevices;
import com.ecom.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public final class NewReleaseTest extends BasicTests {

    private NewReleaseTest(){

    }
    @FrameworkAnnotations(authors = EAuthors.DEVAYANI,categories = ECategories.SMOKE,devices = EDevices.DESKTOP)
    @Test(testName = "HC-3")
    public void newReleaseTest(Map<String,String> data){

        AmazonHomePage amazonHomePage = new AmazonHomePage();
        String newReleasesHeading = amazonHomePage.clickHomeHamBurgerMenu()
                .clickNewRelease(data.get("menutext"))
                .getNewReleasesHeading();

        Assertions.assertThat(newReleasesHeading)
                .isNotEmpty()
                .isNotBlank()
                .isNotNull()
                .as("Banner Text not matching").isEqualTo("Amazon Hot New Releases");
    }
}
