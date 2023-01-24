package PageObjects;

import AbstractComponents.BasePO;
import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPagePO extends BasePO {

    WebDriver driver;


    public LandingPagePO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(xpath = "//form/div/div[3]/div/div/div/input")
    WebElement carModelWindow;

    @FindBy(xpath = "//form/div/div[2]/div/div/div/input")
    WebElement carBrandWindow;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement cookiesAcceptButton;

    //    @FindBy(css = "li:nth-child(2) div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1) span:nth-child(1)")
    @FindBy(xpath = "//div[@data-testid='dropdown']/ul/li[2]")
    WebElement selectedCarBrand;

    @FindBy(xpath = "//div[@data-testid='dropdown']/ul/li")
    WebElement selectedCarModel;

    @FindBy(css = "button[data-testid='submit-btn']")
    WebElement showOffersButton;

    @FindBy(xpath = "//form/div/div[6]/fieldset/div/div[1]/div/input")
    WebElement productionYearFromWindow;

    @FindBy(xpath = "//form/div/div[6]/fieldset/div/div[2]/div/input")
    WebElement productionYearToWindow;

    @FindBy(css = "button[data-testid='advanced-search-link']")
    WebElement advancedSearchButton;



    public AdvancedSearchPO goToAdvancedSearch(){
        advancedSearchButton.click();
        AdvancedSearchPO advancedSearchPO = new AdvancedSearchPO(driver);
        return advancedSearchPO;
    }

    public void cookiesAccept() {
        waitForWebElementToAppear(cookiesAcceptButton);
        cookiesAcceptButton.click();
    }

    public void selectCarBrand(String carBrand) {
        carBrandWindow.sendKeys(carBrand);
        selectedCarBrand.click();
    }

    public void selectCarModel(String carModel) {
        carModelWindow.sendKeys(carModel);
        selectedCarModel.click();
    }

    public void selectCarProductionYearFrom(String yearFrom) {
        productionYearFromWindow.sendKeys(yearFrom);
    }

    public void selectCarProductionYearTo(String yearTo) {
        productionYearToWindow.sendKeys(yearTo);
    }

    public SearchResultsPO searchForOffers() {
        showOffersButton.click();
        SearchResultsPO searchResultsPO = new SearchResultsPO(driver);
        return searchResultsPO;
    }

    public void goToLandingPage() {
        driver.get("https://www.otomoto.pl/");
    }


}
