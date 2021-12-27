package KojinkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView{

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@name = 'email']")
    private WebElement loginField;

    public LoginPage loginInput (String email) {
        loginField.sendKeys(email);
        return this;
    }

    @FindBy(name = "password")
    private WebElement passwordField;

    public LoginPage passwordInput (String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @FindBy(xpath = "//input[@value='Войти']")
    private WebElement entryButton;


    public PersonalAccountPage clickLoginButton() {
        entryButton.click();
        return new PersonalAccountPage(driver);
    }

}
