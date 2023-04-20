package AbstractComponents;

import PageObjects.LandingPage;
import PageObjects.ObservedOffersPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#topLoginLink")
    WebElement loggedUserName;

    @FindBy(css = "div.inner a.website-icon")
    WebElement topOtomotoLogo;

    @FindBy(css = "#observed-counter")
    WebElement observedButton;

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForElementToBeClickable(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }

    public void waitForAttributeToBeNotEmpty(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(findBy, "value"));
    }

    public void waitUntilElementDisappears(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(findBy));
    }

    public ObservedOffersPage goToObservedOffersPage() {
        observedButton.click();
        ObservedOffersPage observedOffersPO = new ObservedOffersPage(driver);
        return observedOffersPO;
    }

    public LandingPage goToLandingPage() {
        waitForElementToBeClickable(topOtomotoLogo);
        topOtomotoLogo.click();
        LandingPage landingPagePO = new LandingPage(driver);
        return landingPagePO;
    }

    public String getLoggedUserNameText() {
        waitForWebElementToAppear(loggedUserName);
        return loggedUserName.getText();
    }
}
