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

    @FindBy(css = ".offer-params li")
    List<WebElement> detailNameList;

    @FindBy(css = ".offer-params li div")
    WebElement detailValue;


    public String getCarProductionYear() {
        String carYear = null;
        for (int i = 0; i < detailNameList.size(); i++) {
            String detailNameText = detailNameList.get(i).getText();
            if (detailNameText.contains("Rok produkcji")){
                carYear = detailNameList.get(i).getText().substring(14, 18);
            }
        }
        return carYear;
    }

    public String getCarDamageStatus(){
        String carDamage = null;
        for (int i = 0; i < detailNameList.size(); i++) {
            String detailNameText = detailNameList.get(i).getText();
            if (detailNameText.contains("Uszkodzony")){
                carDamage = detailNameList.get(i).getText().substring(9,13);
            }else System.out.println("No car damage information");
            break;
        }
        return carDamage;
    }


    public String getOfferTitle() {
        waitForWebElementToAppear(offerTitle);
        return offerTitle.getText();
    }


}
