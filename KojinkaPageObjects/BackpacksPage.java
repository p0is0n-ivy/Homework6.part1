package KojinkaPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BackpacksPage extends BaseView {
    public BackpacksPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@class = 'a-category-kojinka-item']")
    private List<WebElement> backpacksList;

    public ProductDescriptionPage findBackpackByNameClick() {
        backpacksList.stream().filter(p -> p.getText().contains("Кожаный рюкзак \"Вена\" (коричневый антик)")).findFirst().get().click();
        return new ProductDescriptionPage(driver);
    }

}
