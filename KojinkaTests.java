import KojinkaPageObjects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class KojinkaTests {
    WebDriver driver;
    MainPageObject mainPageObject;
    private final static String KOJINKA_BASE_URL = "https://kojinka.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        mainPageObject = new MainPageObject(driver);
        driver.get(KOJINKA_BASE_URL);
    }

    @Test
    void PositiveRegistrationTest() {
        driver.manage().window().setSize(new Dimension(1800, 1000));
        new MainPageObject(driver).clickRegistrationButton();
        new RegistrationKojinkaPage(driver)
                .emailFieldInput("irinas101@mail.ru")
                .firstnameFieldInput("Ирина")
                .telephoneFieldInput("8-911-27-00-30")
                .passwordFieldInput("qwe123")
                .confirmPasswordFieldInput("qwe123")
                .clickRegistrationButton();
        new SuccessfulRegistrationPage(driver).waitSuccessfulRegistrationMessage();
    }

    @Test
    void addSpecificProduct() {
        new MainPageObject(driver)
                .clickLoginButton()
                .loginInput("irinasiv8@mail.ru")
                .passwordInput("qwe12345")
                .clickLoginButton();
        new PersonalAccountPage(driver);
        new CatalogBlock(driver)
                .catalogButtonClick()
                .backpacksClick()
                .findBackpackByNameClick()
                .addShoppingСartButtonClick()
                .AsserThatProductInTheShoppingСartButton();

        /*new MainPageObject(driver).clickLoginButton();
        new LoginPage(driver).loginInput("irinasiv8@mail.ru").passwordInput("qwe12345").clickLoginButton();
        new PersonalAccountPage(driver);
        new CatalogBlock(driver).catalogButtonClick().backpacksClick();
        new BackpacksPage(driver).findBackpackByNameClick();
        new ProductDescriptionPage(driver).addShoppingСartButtonClick();
        new ShoppingСartPage(driver).AsserThatProductInTheShoppingСartButton();*/
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
