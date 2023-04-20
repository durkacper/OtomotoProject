package PageObjects;

import AbstractComponents.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#current-email")
    WebElement emailWindow;

    @FindBy(css = "#current-password")
    WebElement passwordWindow;

    @FindBy(css = "button[data-testid='sign-in-button']")
    WebElement loginButton;

    @FindBy(css = "p[data-testid='generic-error-message']")
    WebElement loginErrorMessage;

    public String getLoginErrorMessageText() {
        waitForWebElementToAppear(loginErrorMessage);
        return loginErrorMessage.getText();
    }

    public LoginPage enterEmail(String email) {
        waitForWebElementToAppear(emailWindow);
        emailWindow.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        passwordWindow.sendKeys(pass);
        return this;
    }

    public MyAccountPage pressLoginButton() {
        loginButton.click();
        MyAccountPage myAccountPO = new MyAccountPage(driver);
        return myAccountPO;
    }
}
