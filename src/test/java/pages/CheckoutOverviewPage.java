package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private By subtotal = By.cssSelector("div[data-test='subtotal-label']");
    private By tax = By.cssSelector("div[data-test='tax-label']");
    private By total = By.cssSelector("div[data-test='total-label']");
    private By cancelButton = By.cssSelector("button[data-test='cancel']");
    private By finishButton = By.cssSelector("button[data-test='finish']");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public double getSubtotal() {
        String stringSubtotal = find(subtotal).getText();
        double newSubtotal = Double.parseDouble(stringSubtotal.substring(stringSubtotal.indexOf("$")+1));
        return newSubtotal;
    }

    public double getTax() {
        String stringTax = find(tax).getText();
        double newTax = Double.parseDouble(stringTax.substring(stringTax.indexOf("$")+1));
        return newTax;
    }

    public double getTotal() {
        String stringTotal = find(total).getText();
        double newTotal = Double.parseDouble(stringTotal.substring(stringTotal.indexOf("$")+1));
        return newTotal;
    }

    public ProductsPage clickCancelButton() {
        click(cancelButton);
        return new ProductsPage(driver);
    }

    public CheckoutCompletePage clickFinishButton() {
        click(finishButton);
        return new CheckoutCompletePage(driver);
    }
}