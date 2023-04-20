package Tests;

import PageObjects.*;
import TestComponents.TestBase;
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
        landingPagePO.goToLandingPageURL()
                .cookiesAccept()
                .selectCarBrand(input.get("brand"))
                .selectCarModel(input.get("model"));
        SearchResultsPage searchResultsPO = landingPagePO.searchForOffers();
        OfferPage offerPO = searchResultsPO.openRandomOfferInResults();
        String offerTitleText = offerPO.getOfferTitle();

        Assert.assertTrue(offerTitleText.contains("Audi " + "RS6"));
    }

    //test 2
    @Test(dataProvider = "getSearchData")
    public void searchCarByProductionYear(HashMap<String, String> input) {
        landingPagePO.goToLandingPageURL()
                .cookiesAccept()
                .selectCarProductionYearFromNewestCars(input.get("yearFrom"));
        SearchResultsPage searchResultsPO = landingPagePO.searchForOffers();
        OfferPage offerPO = searchResultsPO.openRandomOfferInResults();
        String carProductionYearText = offerPO.getCarProductionYear();

        Assert.assertEquals(carProductionYearText, "2023");
    }

    //test 3
    @Test(dataProvider = "getSearchData", groups = {"advancedSearch"})
    public void advancedSearchForDamagedCars(HashMap<String, String> input) throws InterruptedException {
        landingPagePO.goToLandingPageURL()
                .cookiesAccept();
        AdvancedSearchPage advancedSearchPO = landingPagePO.goToAdvancedSearch();
        advancedSearchPO.goToCarStatusSearch()
                .selectDamageRadioButton(input.get("damageOption"));
        SearchResultsPage searchResultsPO = advancedSearchPO.goToResults();
        OfferPage offerPO = searchResultsPO.openRandomOfferInResults();
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
