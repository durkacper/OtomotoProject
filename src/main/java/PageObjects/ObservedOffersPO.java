package PageObjects;

import AbstractComponents.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObservedOffersPO extends BasePO {

    WebDriver driver;

    public ObservedOffersPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(css = "a[data-testid='fav-ad-card']")
    WebElement observedOfferIcon;


    public OfferPO openObservedOffer(){
        observedOfferIcon.click();
        OfferPO offerPO = new OfferPO(driver);
        return offerPO;
    }

}
