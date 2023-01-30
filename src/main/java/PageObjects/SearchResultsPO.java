package PageObjects;

import AbstractComponents.BasePO;
import freemarker.template.Template;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class SearchResultsPO extends BasePO {

    WebDriver driver;

    public SearchResultsPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(css = "article[data-testid='listing-ad']")
    List<WebElement> offersList;

    @FindBy(css = "article[data-variant='regular']:first-child")
    WebElement firstOffer;

    @FindBy(css = "div[data-testid='search-loading-indicator']")
    WebElement loadingSpinner;


    public OfferPO openRandomOfferInResults() {

        waitForWebElementToAppear(firstOffer);
        waitUntilElementDisappears(loadingSpinner);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,250)", "");
        Random random = new Random();
        int randomValue = random.nextInt(offersList.size());
        offersList.get(randomValue).click();
        OfferPO offerPO = new OfferPO(driver);
        return offerPO;
    }

}
