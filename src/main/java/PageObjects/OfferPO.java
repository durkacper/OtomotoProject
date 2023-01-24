package PageObjects;

import AbstractComponents.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OfferPO extends BasePO {

    WebDriver driver;

    public OfferPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(css = "span.offer-title")
    WebElement offerTitle;

    @FindBy(xpath = "//div[@class='parametersArea']/div/ul[1]/li[8]/div") //needs to be modified because details are in different order per offer...
    WebElement productionYear;

    @FindBy(css = ".offer-params li span")
    List<WebElement> detailNameList;

    @FindBy(css = ".offer-params li div")
    WebElement detailValue;


    public String getCarProductionYear() {
        for (int i = 0; i < detailNameList.size(); i++) {                   //maybe fori in fori ???
            detailNameList.get(i).getText();
            if (detailNameList.get(i).equals("Rok produkcji")) {
                detailValue.getText();
            }
        }
        //return productionYear.getText();
        return detailValue.getText();
    }

    public String getOfferTitle() {
        waitForWebElementToAppear(offerTitle);
        return offerTitle.getText();
    }


}
