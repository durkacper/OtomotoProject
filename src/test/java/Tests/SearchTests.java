package Tests;

import PageObjects.SearchResultsPO;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests extends TestBase {

    //test 1
    @Test
    public void searchCarByBrandAndModelTest() throws InterruptedException {

        landingPagePO.goToLandingPage();
        landingPagePO.cookiesAccept();
        landingPagePO.selectCarBrand("Audi");
        landingPagePO.selectCarModel("RS6");
//        landingPagePO.searchForOffers();
        SearchResultsPO searchResultsPO = landingPagePO.searchForOffers();


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
