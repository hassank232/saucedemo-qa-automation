package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By productsPageTitle = By.cssSelector("span[data-test='title']");
    private By totalCartItems = By.cssSelector("span[data-test='shopping-cart-badge']");
    private By goToCartButton = By.cssSelector("a[data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductsPageTitle() {
        return find(productsPageTitle).getText();
    }

    public void addItemToCart(String itemName) {
        String itemToAdd = "add-to-cart-" + itemName.toLowerCase().replace(" ", "-");
        click(By.cssSelector("button[data-test='" + itemToAdd + "']"));
    }

    public void removeItemFromCart(String itemName) {
        String itemToRemove = "remove-" + itemName.toLowerCase().replace(" ", "-");
        click(By.cssSelector("button[data-test='" + itemToRemove + "']"));
    }

    public int getCartCount() {
        try {
            return Integer.parseInt(find(totalCartItems).getText());
        }
        catch (NoSuchElementException e) {
            return 0;
        }
    }

    public CartsPage goToCart() {
        click(goToCartButton);
        return new CartsPage(driver);
    }
}