package Tests;

import PageObjects.*;
import TestComponents.TestBase;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SearchTests extends TestBase {

    //test 1
    @Test(dataProvider = "getSearchData")
    public void searchCarByBrandAndModelTest(HashMap<String, String> input) {

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        landingPagePO.selectCarBrand(input.get("brand"));
        landingPagePO.selectCarModel(input.get("model"));
        SearchResultsPO searchResultsPO = landingPagePO.searchForOffers();
        OfferPO offerPO = searchResultsPO.openRandomOfferInResults();
        String offerTitleText = offerPO.getOfferTitle();

        Assert.assertTrue(offerTitleText.contains("Audi " + "RS6"));

    }


    //test 2
    @Test(dataProvider = "getSearchData")
    public void searchCarByProductionYear(HashMap<String, String> input) {

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        landingPagePO.selectCarProductionYearFromNewestCars(input.get("yearFrom"));
        SearchResultsPO searchResultsPO = landingPagePO.searchForOffers();
        OfferPO offerPO = searchResultsPO.openRandomOfferInResults();
        String carProductionYearText = offerPO.getCarProductionYear();

        Assert.assertEquals(carProductionYearText, "2023");

    }


    //test 3
    @Test(dataProvider = "getSearchData", groups = {"advancedSearch"})
    public void advancedSearchForDamagedCars(HashMap<String, String> input) throws InterruptedException {

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        AdvancedSearchPO advancedSearchPO = landingPagePO.goToAdvancedSearch();
        advancedSearchPO.goToCarStatusSearch();
        advancedSearchPO.selectDamageRadioButton(input.get("damageOption"));
        SearchResultsPO searchResultsPO = advancedSearchPO.goToResults();
        OfferPO offerPO = searchResultsPO.openRandomOfferInResults();
        offerPO.getCarDamageStatus();
        String carDamageStatusText = offerPO.getCarDamageStatus();

        Assert.assertEquals(carDamageStatusText, "Tak");

    }


    @DataProvider
    public Object[][] getSearchData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/Data/searchData.json");
        return new Object[][]{{data.get(0)}};
    }


}
