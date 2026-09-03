package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private By checkoutPageTitle = By.cssSelector("span[data-test='title']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getCheckoutPageTitle() {
        return find(checkoutPageTitle).getText();
    }
}