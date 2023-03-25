package PageObjects;

import AbstractComponents.BasePO;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(xpath = "//div[@data-testid='grouped-filters']/div/div[2]/div[@role='button']")
    WebElement carStatusButton;

    @FindBy(xpath = "//div[@data-testid='modal-backdrop']/div/div[2]/div/div[3]/label")
    List<WebElement> damageRadioButtonsList;

    @FindBy(xpath = "//footer/button[2]")
    WebElement showResultsButton;

    public AdvancedSearchPO selectDamageRadioButton(String damageOption) {
        for (int i = 0; i < damageRadioButtonsList.size(); i++) {
            String damageRadioButtonText = damageRadioButtonsList.get(i).getText();
            if (damageRadioButtonText.equals(damageOption)) {
                damageRadioButtonsList.get(i).click();
            }
        }
        return this;
    }

    public SearchResultsPO goToResults() throws InterruptedException {
        waitForElementToBeClickable(showResultsButton);
        Thread.sleep(3000);
        showResultsButton.click();
        SearchResultsPO searchResultsPO = new SearchResultsPO(driver);
        return searchResultsPO;
    }

    public AdvancedSearchPO goToCarStatusSearch() {
        waitForElementToBeClickable(carStatusButton);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,250)", "");
        carStatusButton.click();
        return this;
    }
}
