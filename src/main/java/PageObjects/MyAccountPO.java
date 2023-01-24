package PageObjects;

import AbstractComponents.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPO extends BasePO {

    WebDriver driver;

    public MyAccountPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#topLoginLink")
    WebElement loggedUserName;


    public String getLoggedUserNameText(){
        waitForWebElementToAppear(loggedUserName);
        return loggedUserName.getText();
    }

}
