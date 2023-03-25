package PageObjects;

import AbstractComponents.BasePO;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OfferPO extends BasePO {

    WebDriver driver;
    public String carDamage;

    public OfferPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "span.offer-title")
    WebElement offerTitle;

    @FindBy(css = "div.favorite-wrapper")
    WebElement addToFavoritesButton;

    @FindBy(css = "button[data-test='close-favourite-modal']")
    WebElement closeFavoriteModalButton;

    @FindBy(xpath = "//div[@class='offer-content__metabar']//span[@id='ad_id']")
    WebElement offerID;

    @FindBy(xpath = "//div[@class='offer-summary']/span[2]/span[1]")
    WebElement productionYear;

    @FindBy(xpath = "//div[@class='offer-params with-vin']/ul[2]/li/span")
    List<WebElement> detailsNameList;

    @FindBy(xpath = "//div[@class='offer-params with-vin']/ul[2]/li/div")
    List<WebElement> detailsValueList;

    public String getOfferID() {
        waitForWebElementToAppear(offerID);
        return offerID.getText();
    }

    public OfferPO closeFavoriteModal() {
        waitForElementToBeClickable(closeFavoriteModalButton);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", closeFavoriteModalButton);
        return this;
    }

    public OfferPO addToFavorites() {
        addToFavoritesButton.click();
        return this;
    }

    public String getCarProductionYear() {
        return productionYear.getText();
    }

    public String getCarDamageStatus() {
        for (int i = 0; i < detailsNameList.size(); i++) {
            if (detailsNameList.get(i).getText().contains("Uszkodzony")) {
                carDamage = detailsValueList.get(i).getText();
            } else System.out.println("No car damage information");
        }
        return carDamage;
    }

    public String getOfferTitle() {
        waitForWebElementToAppear(offerTitle);
        return offerTitle.getText();
    }
}
