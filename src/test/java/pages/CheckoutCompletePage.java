package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private By thankYouMessage = By.cssSelector("h2[data-test='complete-header']");
    private By backHomeButton = By.cssSelector("button[data-test='back-to-products']");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public String getThankYouMessage() {
        return find(thankYouMessage).getText();
    }

    public ProductsPage clickBackHomeButton() {
        click(backHomeButton);
        return new ProductsPage(driver);
    }
}