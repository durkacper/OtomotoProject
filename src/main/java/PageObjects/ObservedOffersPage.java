package PageObjects;

import AbstractComponents.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObservedOffersPage extends BasePage {

    WebDriver driver;

    public ObservedOffersPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "a[data-testid='fav-ad-card']")
    WebElement observedOfferIcon;

    public OfferPage openObservedOffer() {
        observedOfferIcon.click();
        OfferPage offerPO = new OfferPage(driver);
        return offerPO;
    }
}
