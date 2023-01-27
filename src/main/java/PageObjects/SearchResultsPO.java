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

    @FindBy(xpath = "//main[@data-testid='search-results']/article[1]")
    WebElement firstOfferInResults;

    @FindBy(css = "article[data-variant='regular']")
    List<WebElement> offersList;



    public OfferPO openRandomOfferInResults() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("return document.readyState").toString().equals("complete");
        waitForElementToBeClickable(firstOfferInResults);
        Random random = new Random();
        int randomValue = random.nextInt(offersList.size());
        offersList.get(randomValue).click();
        OfferPO offerPO = new OfferPO(driver);
        return offerPO;
    }




}
