package KojinkaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogBlock extends BaseView {
    public CatalogBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div/p[contains(., 'Каталог')]")
    private WebElement catalogButton;

    public CatalogBlock catalogButtonClick() {
        catalogButton.click();
        return this;
    }

    @FindBy(xpath = "//a[@class='open-pod-menu']/h2[contains(.,'Рюкзаки')]")
    private WebElement backpacksSection;

    public BackpacksPage backpacksClick() {
        backpacksSection.click();
        return new BackpacksPage(driver);
    }
}


