package PageObjects;

import AbstractComponents.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AdvancedSearchPage extends BasePage {

    WebDriver driver;

    public AdvancedSearchPage(WebDriver driver) {
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

    public AdvancedSearchPage selectDamageRadioButton(String damageOption) {
        for (int i = 0; i < damageRadioButtonsList.size(); i++) {
            String damageRadioButtonText = damageRadioButtonsList.get(i).getText();
            if (damageRadioButtonText.equals(damageOption)) {
                damageRadioButtonsList.get(i).click();
            }
        }
        return this;
    }

    public SearchResultsPage goToResults() throws InterruptedException {
        waitForElementToBeClickable(showResultsButton);
        Thread.sleep(3000);
        showResultsButton.click();
        SearchResultsPage searchResultsPO = new SearchResultsPage(driver);
        return searchResultsPO;
    }

    public AdvancedSearchPage goToCarStatusSearch() {
        waitForElementToBeClickable(carStatusButton);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,250)", "");
        carStatusButton.click();
        return this;
    }
}
