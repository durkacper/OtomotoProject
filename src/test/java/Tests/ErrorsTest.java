package Tests;

import PageObjects.LoginPO;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorsTest extends TestBase {

    //test 6
    @Test
    public void setIncorrectCarPriceInSearchTest() {

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        landingPagePO.selectCarProductionYearTo("2019");
        landingPagePO.selectCarProductionYearFrom("2020");
        Boolean errorDisplay = landingPagePO.checkIfErrorSymbolIsDisplayed();

        Assert.assertEquals(Boolean.TRUE, errorDisplay);

    }


    //test 7
    @Test
    public void loginWithInvalidCredentialsTest(){

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        LoginPO loginPO = landingPagePO.goToLoginPage();
        loginPO.enterEmail("badLogin@mail.com");
        loginPO.enterPassword("invalidPass");
        loginPO.pressLoginButton();
        String errorMessageText = loginPO.getLoginErrorMessageText();

        Assert.assertEquals(errorMessageText, "Nieprawidłowy email lub hasło.");

    }


    //test 8
    @Test
    public void intentionalFailTest(){

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        LoginPO loginPO = landingPagePO.goToLoginPage();
        loginPO.enterEmail("badLogin@mail.com");
        loginPO.enterPassword("invalidPass");
        loginPO.pressLoginButton();
        String errorMessageText = loginPO.getLoginErrorMessageText();

        Assert.assertEquals(errorMessageText, "Wrong 'expected' to invoke failure");

    }

}
