package Tests;

import PageObjects.LoginPO;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ErrorsTest extends TestBase {

    //test 6
    @Test(dataProvider = "getSearchLoginData")
    public void setIncorrectCarPriceInSearchTest(HashMap<String, String> input) {

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        landingPagePO.selectCarProductionYearFrom(input.get("yearFrom"));
        landingPagePO.selectCarProductionYearTo(input.get("yearTo"));
        Boolean yearFrom = landingPagePO.checkIfYearFromWindowIsEmpty();

        Assert.assertEquals(yearFrom, Boolean.TRUE);

    }


    //test 7
    @Test(dataProvider = "getInvalidLoginData")
    public void loginWithInvalidCredentialsTest(HashMap<String, String> input) {

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        LoginPO loginPO = landingPagePO.goToLoginPage();
        loginPO.enterEmail(input.get("invalidLogin"));
        loginPO.enterPassword(input.get("invalidPass"));
        loginPO.pressLoginButton();
        String errorMessageText = loginPO.getLoginErrorMessageText();

        Assert.assertEquals(errorMessageText, "Nieprawidłowy email lub hasło.");

    }


    //test 8
    @Test(dataProvider = "getInvalidLoginData")
    public void intentionalFailTest(HashMap<String, String> input) {

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        LoginPO loginPO = landingPagePO.goToLoginPage();
        loginPO.enterEmail(input.get("invalidLogin"));
        loginPO.enterPassword(input.get("invalidPass"));
        loginPO.pressLoginButton();
        String errorMessageText = loginPO.getLoginErrorMessageText();

        Assert.assertEquals(errorMessageText, "Wrong 'expected' to invoke failure");

    }


    @DataProvider
    public Object[][] getInvalidLoginData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/Data/loginData.json");
        return new Object[][]{{data.get(1)}};
    }

    @DataProvider
    public Object[][] getSearchLoginData() throws IOException {

        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/Data/searchData.json");
        return new Object[][]{{data.get(1)}};
    }

}
