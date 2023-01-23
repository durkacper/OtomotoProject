package Tests;

import PageObjects.OfferPO;
import PageObjects.SearchResultsPO;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends TestBase {

    //test 1
    @Test
    public void searchCarByBrandAndModelTest() {

        landingPagePO.goToLandingPage();
        landingPagePO.cookiesAccept();
        landingPagePO.selectCarBrand("Audi");
        landingPagePO.selectCarModel("RS6");
        SearchResultsPO searchResultsPO = landingPagePO.searchForOffers();
        searchResultsPO.openFirstOfferInResults();
        OfferPO offerPO = new OfferPO(driver);
        offerPO.getOfferTitle();
        String offerTitleText = offerPO.getOfferTitle();

        Assert.assertTrue(offerTitleText.contains("Audi " + "RS6"));

        //add chaining, data from resources

    }


    //test 2
    @Test
    public void searchCarByProductionYear() {

        landingPagePO.goToLandingPage();
        landingPagePO.cookiesAccept();
        landingPagePO.selectCarProductionYearFrom("2000");
        landingPagePO.selectCarProductionYearTo("2008");
        landingPagePO.searchForOffers();


    }


}
