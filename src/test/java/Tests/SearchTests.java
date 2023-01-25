package Tests;

import PageObjects.*;
import TestComponents.TestBase;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends TestBase {

    //test 1
    @Test
    public void searchCarByBrandAndModelTest() {

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        landingPagePO.selectCarBrand("Audi");
        landingPagePO.selectCarModel("RS6");
        SearchResultsPO searchResultsPO = landingPagePO.searchForOffers();
        OfferPO offerPO = searchResultsPO.openFirstOfferInResults();
        String offerTitleText = offerPO.getOfferTitle();

        Assert.assertTrue(offerTitleText.contains("Audi " + "RS6"));

        // read data from json file
        // add description
    }


    //test 2
    @Test
    public void searchCarByProductionYear() {

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        landingPagePO.selectCarProductionYearFrom("2020");
        landingPagePO.selectCarProductionYearTo("2020");
        SearchResultsPO searchResultsPO = landingPagePO.searchForOffers();
        OfferPO offerPO = searchResultsPO.openFirstOfferInResults();
        String carProductionYearText = offerPO.getCarProductionYear();

        Assert.assertEquals(carProductionYearText, "2020");

        // read data from json file
        // add description
    }


    //test 3
    @Test
    public void advancedSearchForDamagedCars(){

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        AdvancedSearchPO advancedSearchPO = landingPagePO.goToAdvancedSearch();
        advancedSearchPO.goToCarStatusSearch();
        advancedSearchPO.selectDamageRadioButton("Tak");
        AdvancedSearchResultsPO advancedSearchResultsPO = advancedSearchPO.goToResults();
        OfferPO offerPO = advancedSearchResultsPO.openFirstOfferInAdvancedResults();
        String carDamageStatusText = offerPO.getCarDamageStatus();

        Assert.assertEquals(carDamageStatusText, "Tak");

    }


}
