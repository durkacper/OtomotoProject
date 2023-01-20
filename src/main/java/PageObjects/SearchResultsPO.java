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







//    @FindBy(css = "h2[data-testid='ad-title']")
//    List<WebElement> offersTitlesList;
//
//    public List<String> getOffersTitleText() {
//        for (int i = 0; i < offersTitlesList.size(); i++) {
//            String titleText = offersTitlesList.get(i).getText();
//        }
//        return null;
//    }


}
