package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartsPage extends BasePage {

    private By cartsPageTitle = By.cssSelector("span[data-test='title']");

    public CartsPage(WebDriver driver) {
        super(driver);
    }

    public String getCartsPageTitle() {
        return find(cartsPageTitle).getText();
    }
}