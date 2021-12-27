package KojinkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ProductDescriptionPage extends BaseView {
    public ProductDescriptionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/p[contains(.,'В Корзину')]")
    WebElement addShoppingСartButton;

    public ShoppingСartPage addShoppingСartButtonClick() {
        addShoppingСartButton.click();
        return new ShoppingСartPage(driver);
    }
}




