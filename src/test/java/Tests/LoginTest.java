package Tests;

import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestComponents.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends TestBase {

    //test 4
    @Test(dataProvider = "getLoginData")
    public void loginTest(HashMap<String, String> input) {
        landingPagePO.goToLandingPageURL()
                .cookiesAccept();
        LoginPage loginPO = landingPagePO.goToLoginPage();
        loginPO.enterEmail(input.get("login"))
                .enterPassword(input.get("pass"));
        MyAccountPage myAccountPO = loginPO.pressLoginButton();
        String loggedUserNameText = myAccountPO.getLoggedUserNameText();

        Assert.assertEquals(loggedUserNameText, "otomototestuser");
    }

    @DataProvider
    public Object[][] getLoginData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "/src/test/java/Data/loginData.json");
        return new Object[][]{{data.get(0)}};
    }
}
