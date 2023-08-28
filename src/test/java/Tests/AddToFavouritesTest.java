package Tests;

import PageObjects.*;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AddToFavouritesTest extends TestBase {

    //test5
    @Test(dataProvider = "getLoginData")
    public void addOfferToFavouritesTest(HashMap<String, String> input) {

        OfferPage offerPO = new OfferPage(driver);

        landingPagePO.goToLandingPageURL();
        LoginPage loginPO = landingPagePO.goToLoginPage();
        loginPO.enterEmail(input.get("login"))
                .enterPassword(input.get("pass"))
                .goToLandingPage()
                .searchForOffers()
                .openRandomOfferInResults();
        String offerID1 = offerPO.getOfferID();
        offerPO.addToFavorites()
                .closeFavoriteModal()
                .goToObservedOffersPage()
                .openObservedOffer();
        String offerID2 = offerPO.getOfferID();

        Assert.assertEquals(offerID2, offerID1);
    }

    @DataProvider
    public Object[][] getLoginData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/Data/loginData.json");
        return new Object[][]{{data.get(0)}};
    }
}
