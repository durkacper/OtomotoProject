package PageObjects;

import AbstractComponents.BasePO;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(css = ".offer-params li")
    List<WebElement> detailNameList;

    @FindBy(css = "div.favorite-wrapper")
    WebElement addToFavoritesButton;

    @FindBy(css = "button[data-test='close-favourite-modal']")
    WebElement closeFavoriteModalButton;

    @FindBy(xpath = "//div[@class='offer-content__metabar']//span[@id='ad_id']")
    WebElement offerID;


    public String getOfferID(){
        waitForWebElementToAppear(offerID);
        return offerID.getText();
    }


    public void closeFavoriteModal() {
        waitForElementToBeClickable(closeFavoriteModalButton);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click()", closeFavoriteModalButton);
    }


    public void addToFavorites() {
        addToFavoritesButton.click();
    }


    public String getCarProductionYear() {
        String carYear = null;
        for (int i = 0; i < detailNameList.size(); i++) {
            String detailNameText = detailNameList.get(i).getText();
            if (detailNameText.contains("Rok produkcji")) {
                carYear = detailNameList.get(i).getText().substring(14, 18);
            }
        }
        return carYear;
    }

    public String getCarDamageStatus() {
        String carDamage = null;
        for (int i = 0; i < detailNameList.size(); i++) {
            String detailNameText = detailNameList.get(i).getText();
            if (detailNameText.contains("Uszkodzony")) {
                carDamage = detailNameList.get(i).getText().substring(9, 13);
            } else System.out.println("No car damage information");
            break;
        }
        return carDamage;
    }


    public String getOfferTitle() {
        waitForWebElementToAppear(offerTitle);
        return offerTitle.getText();
    }

    public void closeAlert() {
        driver.switchTo().alert().dismiss();
    }


}
