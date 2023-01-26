package PageObjects;

import AbstractComponents.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO extends BasePO {

    WebDriver driver;
    public LoginPO(WebDriver driver) {
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


    public String getLoginErrorMessageText(){
        waitForWebElementToAppear(loginErrorMessage);
        return loginErrorMessage.getText();
    }

    public void enterEmail(String email){
        emailWindow.sendKeys(email);
    }

    public void enterPassword(String pass){
        passwordWindow.sendKeys(pass);
    }

    public MyAccountPO pressLoginButton(){
        loginButton.click();
        MyAccountPO myAccountPO = new MyAccountPO(driver);
        return myAccountPO;
    }


}
