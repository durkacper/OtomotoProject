package PageObjects;

import AbstractComponents.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearchResultsPO extends BasePO {

    WebDriver driver;

    public AdvancedSearchResultsPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//main[@data-testid='search-results']/article[1]")
    WebElement firstOfferInAdvancedResults;


    public OfferPO openFirstOfferInAdvancedResults(){
        waitForWebElementToAppear(firstOfferInAdvancedResults);
        firstOfferInAdvancedResults.click();
        OfferPO offerPO = new OfferPO(driver);
        return offerPO;
    }
}
