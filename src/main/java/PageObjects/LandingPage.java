package PageObjects;

import AbstractComponents.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    WebDriver driver;

    public LandingPage(WebDriver driver) {
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

    @FindBy(xpath = "//div[@data-testid='dropdown']/ul/li[2]")
    WebElement selectedCarBrand;

    @FindBy(xpath = "//div[@data-testid='dropdown']/ul/li")
    WebElement selectedCarModel;

    @FindBy(xpath = "//button[@type='submit'][1]")
    WebElement showOffersButton;

    @FindBy(xpath = "//form/div/div[6]/fieldset/div/div[1]/div/input")
    WebElement productionYearFromWindow;

    @FindBy(xpath = "//form/div/div[6]/fieldset/div/div[2]/div/input")
    WebElement productionYearToWindow;

    @FindBy(xpath = "//form/div/div[6]/fieldset/div/div[1]/ul/li")
    WebElement productionYearFromOnList;

    @FindBy(xpath = "//form/div/div[6]/fieldset/div/div[2]/ul/li")
    WebElement productionYearToOnList;

    @FindBy(css = "button[data-testid='advanced-search-link']")
    WebElement advancedSearchButton;

    @FindBy(css = "button[data-testid='usermenu-link-login']")
    WebElement loginButton;

    public Boolean checkIfYearFromWindowIsEmpty() {
        return productionYearFromWindow.getAttribute("value").isEmpty();
    }

    public LoginPage goToLoginPage() {
        waitForWebElementToAppear(loginButton);
        loginButton.click();
        LoginPage loginPO = new LoginPage(driver);
        return loginPO;
    }

    public AdvancedSearchPage goToAdvancedSearch() {
        advancedSearchButton.click();
        AdvancedSearchPage advancedSearchPO = new AdvancedSearchPage(driver);
        return advancedSearchPO;
    }

    public LandingPage selectCarBrand(String carBrand) {
        carBrandWindow.sendKeys(carBrand);
        selectedCarBrand.click();
        return this;
    }

    public LandingPage selectCarModel(String carModel) {
        carModelWindow.sendKeys(carModel);
        selectedCarModel.click();
        return this;
    }

    public LandingPage selectCarProductionYearFromNewestCars(String yearFrom) {
        productionYearFromWindow.sendKeys(yearFrom);
        return this;
    }

    public LandingPage selectCarProductionYearFrom(String yearFrom) {
        productionYearFromWindow.sendKeys(yearFrom);
        waitForElementToBeClickable(productionYearFromOnList);
        productionYearFromOnList.click();
        return this;
    }

    public LandingPage selectCarProductionYearTo(String yearTo) {
        waitForAttributeToBeNotEmpty(productionYearFromWindow);
        productionYearToWindow.sendKeys(yearTo);
        waitForElementToBeClickable(productionYearToOnList);
        productionYearToOnList.click();
        return this;
    }

    public SearchResultsPage searchForOffers() {
        waitForWebElementToAppear(showOffersButton);
        showOffersButton.click();
        SearchResultsPage searchResultsPO = new SearchResultsPage(driver);
        return searchResultsPO;
    }

    public LandingPage goToLandingPageURL() {
        driver.get("https://www.otomoto.pl/");
        waitForWebElementToAppear(cookiesAcceptButton);
        cookiesAcceptButton.click();
        return this;
    }
}
