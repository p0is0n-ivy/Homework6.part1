package KojinkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


    public class MainPageObject extends BaseView {
        @FindBy(xpath = "//li[.='Регистрация']")
        WebElement registrationButton;

        public RegistrationKojinkaPage clickRegistrationButton() {
            registrationButton.click();
            return new RegistrationKojinkaPage(driver);
        }
        @FindBy(xpath = "//li[contains(.,'ВОЙТИ')]")
        private WebElement loginButton;

        public LoginPage clickLoginButton() {
            loginButton.click();
            return new LoginPage(driver);
        }



        public MainPageObject(WebDriver driver) {
            super(driver);
        }
    }

