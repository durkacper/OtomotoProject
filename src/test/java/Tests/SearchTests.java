package Tests;

import PageObjects.OfferPage;
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
                .selectCarBrand(input.get("brand"))
                .selectCarModel(input.get("model"))
                .searchForOffers()
                .openRandomOfferInResults();
        OfferPage offerPO = new OfferPage(driver);
        String offerTitleText = offerPO.getOfferTitle();

        Assert.assertTrue(offerTitleText.contains("Audi " + "RS6"));
    }

    //test 2
    @Test(dataProvider = "getSearchData")
    public void searchCarByProductionYear(HashMap<String, String> input) {
        landingPagePO.goToLandingPageURL()
                .selectCarProductionYearFromNewestCars(input.get("yearFrom"))
                .searchForOffers()
                .openRandomOfferInResults();
        OfferPage offerPO = new OfferPage(driver);
        String carProductionYearText = offerPO.getCarProductionYear();

        Assert.assertEquals(carProductionYearText, "2023");
    }

    //test 3
    @Test(dataProvider = "getSearchData", groups = {"advancedSearch"})
    public void advancedSearchForDamagedCars(HashMap<String, String> input) throws InterruptedException {
        landingPagePO.goToLandingPageURL()
                .goToAdvancedSearch()
                .goToCarStatusSearch()
                .selectDamageRadioButton(input.get("damageOption"))
                .goToResults()
                .openRandomOfferInResults()
                .getCarDamageStatus();
        OfferPage offerPO = new OfferPage(driver);
        String carDamageStatusText = offerPO.getCarDamageStatus();

        Assert.assertEquals(carDamageStatusText, "Tak");
    }

    @DataProvider
    public Object[][] getSearchData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/Data/searchData.json");
        return new Object[][]{{data.get(0)}};
    }
}
