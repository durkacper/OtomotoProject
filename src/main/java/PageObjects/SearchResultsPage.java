package PageObjects;

import AbstractComponents.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SearchResultsPage extends BasePage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
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

    public OfferPage openRandomOfferInResults() {
        waitForWebElementToAppear(firstOffer);
        waitUntilElementDisappears(loadingSpinner);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,250)", "");
        Random random = new Random();
        int randomValue = random.nextInt(offersList.size());
        offersList.get(randomValue).click();
        OfferPage offerPO = new OfferPage(driver);
        return offerPO;
    }
}
