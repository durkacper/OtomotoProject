package PageObjects;

import AbstractComponents.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPO extends BasePO {

    WebDriver driver;

    public SearchResultsPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//main[@data-testid='search-results']/article[1]")
    WebElement firstOfferInResults;


    public OfferPO openFirstOfferInResults(){
        waitForElementToBeClickable(firstOfferInResults);
        firstOfferInResults.click();
        OfferPO offerPO = new OfferPO(driver);
        return offerPO;
    }





// Random select

//public void selectRandomCommand() {
//    Select commandSelect = new Select(commands);
//    List<WebElement> commandsOptions = commandSelect.getOptions();
//    int howManyOption = getRandomNumber(commandsOptions.size());
//    for (int i = 0; i < howManyOption; i++) {
//        commandSelect.selectByIndex(i);
//    }
//}
//
//
//    public void selectRandomContinent() {
//        Select continents = new Select(selectContinents);
//        List<WebElement> continentsOptions = continents.getOptions();
//        continentsOptions.remove(0);
//        WebElement randomOption = getRandomElement(continentsOptions);
//        continents.selectByVisibleText(randomOption.getText());
//    }





}
