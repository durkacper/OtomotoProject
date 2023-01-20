package PageObjects;

import AbstractComponents.BasePO;
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

    @FindBy(css = "button[data-testid='submit-btn']")
    WebElement showOffersButton;


    public void cookiesAccept() {
        waitForWebElementToAppear(cookiesAcceptButton);
        cookiesAcceptButton.click();
    }

    public void selectCarBrand(String carBrand) {
        carBrandWindow.sendKeys(carBrand);
        selectedCarBrand.click();
    }

    public void selectCarModel(String carModel){
        carModelWindow.sendKeys(carModel);
    }

    public void selectCarProductionYearFrom(String yearFrom){
    }

    public void selectCarProductionYearTo(String yearTo){
    }

    public SearchResultsPO searchForOffers(){
        showOffersButton.click();
        SearchResultsPO searchResultsPO= new SearchResultsPO(driver);
        return searchResultsPO;
    }

    public void goToLandingPage() {
        driver.get("https://www.otomoto.pl/");
    }


}
