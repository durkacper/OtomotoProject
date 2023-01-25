package Tests;

import PageObjects.LoginPO;
import PageObjects.MyAccountPO;
import TestComponents.TestBase;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    //test 4
    @Test
    public void loginTest() {

        landingPagePO.goToLandingPageURL();
        landingPagePO.cookiesAccept();
        LoginPO loginPO = landingPagePO.goToLoginPage();
        loginPO.enterEmail("otomototestuser@gazeta.pl");
        loginPO.enterPassword("Otomotopass123");
        MyAccountPO myAccountPO = loginPO.pressLoginButton();
        String loggedUserNameText = myAccountPO.getLoggedUserNameText();

        Assert.assertEquals(loggedUserNameText, "otomototestuser");
    }
}
