package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartsPage extends BasePage {

    private By cartsPageTitle = By.cssSelector("span[data-test='title']");
    private By itemName = By.cssSelector("div[data-test='inventory-item-name']");
    private By itemPrice = By.cssSelector("div[data-test='inventory-item-price']");
    private By checkout = By.cssSelector("button[data-test='checkout']");

    public CartsPage(WebDriver driver) {
        super(driver);
    }

    public String getCartsPageTitle() {
        return find(cartsPageTitle).getText();
    }

    public String getItemName() {
        return find(itemName).getText();
    }

    public String getItemPrice() {
        return find(itemPrice).getText();
    }

    public CheckoutPage gotoCheckout() {
        click(checkout);
        return new CheckoutPage(driver);
    }
}