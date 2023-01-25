package TestComponents;

import PageObjects.LandingPagePO;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    public WebDriver driver;
    public LandingPagePO landingPagePO;


    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }


    @BeforeMethod
    public LandingPagePO launchApplication() {
        driver = initializeDriver();
        landingPagePO = new LandingPagePO(driver);
        landingPagePO.goToLandingPageURL();
        return landingPagePO;
    }

//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        driver.close();
//    }

}
