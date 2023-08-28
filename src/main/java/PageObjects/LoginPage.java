package PageObjects;

import AbstractComponents.BasePage;
import org.openqa.selenium.JavascriptExecutor;
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

    @FindBy(css = "input[name='username']")
    WebElement emailWindow;

    @FindBy(css = "input[name='password']")
    WebElement passwordWindow;

    @FindBy(css = "button[type='submit']")
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        loginButton.click();
        MyAccountPage myAccountPO = new MyAccountPage(driver);
        return myAccountPO;
    }
}
