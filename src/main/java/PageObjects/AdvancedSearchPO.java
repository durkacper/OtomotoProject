package PageObjects;

import AbstractComponents.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdvancedSearchPO extends BasePO {

    WebDriver driver;

    public AdvancedSearchPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "(//div[@data-testid='modal-toggler'])[2]")
    WebElement carStatusButton;

    @FindBy(xpath = "//div[@data-testid='modal-backdrop']/div/div[2]/div/div[3]/label")
    List<WebElement> damageRadioButtonsList;

    @FindBy(xpath = "//footer/button[2]")
    WebElement showResultsButton;


    public void selectDamageRadioButton(String damageOption) {
        for (int i = 0; i < damageRadioButtonsList.size(); i++) {
            String damageRadioButtonText = damageRadioButtonsList.get(i).getText();
            if (damageRadioButtonText.equals(damageOption)) {
                damageRadioButtonsList.get(i).click();
            }
        }
    }


    public AdvancedSearchResultsPO goToResults() {
        showResultsButton.click();
        AdvancedSearchResultsPO advancedSearchResultsPO = new AdvancedSearchResultsPO(driver);
        return advancedSearchResultsPO;
    }


    public void goToCarStatusSearch() {
        waitForElementToBeClickable(carStatusButton);
        carStatusButton.click();
    }


}
