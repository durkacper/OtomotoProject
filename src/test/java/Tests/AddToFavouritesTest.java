package Tests;

import PageObjects.*;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToFavouritesTest extends TestBase {

    //test5
    @Test
    public void addOfferToFavourites(){

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        LoginPO loginPO = landingPagePO.goToLoginPage();
        loginPO.enterEmail("otomototestuser@gazeta.pl");
        loginPO.enterPassword("Otomotopass123");
        MyAccountPO myAccountPO = loginPO.pressLoginButton();
        myAccountPO.goToLandingPage();
        SearchResultsPO searchResultsPO = landingPagePO.searchForOffers();
        OfferPO offerPO = searchResultsPO.openRandomOfferInResults();
        String offerTitle1 = offerPO.getOfferTitle();
        offerPO.addToFavorites();
        offerPO.closeFavoriteModal();
        ObservedOffersPO observedOffersPO = offerPO.goToObservedOffersPage();
        observedOffersPO.openObservedOffer();
        String offerTitle2 = offerPO.getOfferTitle();

        Assert.assertEquals(offerTitle2, offerTitle1);

    }

}
