package AbstractComponents;

import PageObjects.LandingPagePO;
import PageObjects.ObservedOffersPO;
import freemarker.template.Template;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePO {

    WebDriver driver;

    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForElementToBeClickable(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(findBy));
    }


    @FindBy(css = "#topLoginLink")
    WebElement loggedUserName;

    @FindBy(css = "div.inner a.website-icon")
    WebElement topOtomotoLogo;

    @FindBy(css = "#observed-counter")
    WebElement observedButton;


    public ObservedOffersPO goToObservedOffersPage(){
        observedButton.click();
        ObservedOffersPO observedOffersPO = new ObservedOffersPO(driver);
        return observedOffersPO;
    }

    public LandingPagePO goToLandingPage(){
        waitForElementToBeClickable(topOtomotoLogo);
        topOtomotoLogo.click();
        LandingPagePO landingPagePO = new LandingPagePO(driver);
        return landingPagePO;
    }

    public String getLoggedUserNameText(){
        waitForWebElementToAppear(loggedUserName);
        return loggedUserName.getText();
    }


}
