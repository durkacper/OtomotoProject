package PageObjects;

import AbstractComponents.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OfferPO extends BasePO {

    WebDriver driver;

    public OfferPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(css = "span.offer-title")
    WebElement offerTitle;

    public String getOfferTitle(){
        waitForWebElementToAppear(offerTitle);
        return offerTitle.getText();
    }


}
