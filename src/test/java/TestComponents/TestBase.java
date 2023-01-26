package TestComponents;

import PageObjects.LandingPagePO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

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

    public List<HashMap<String, String>> getJsonDataToMap(String FilePath) throws IOException {

        String jsonContent = FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;
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
