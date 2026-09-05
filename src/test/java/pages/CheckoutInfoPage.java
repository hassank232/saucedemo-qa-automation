package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInfoPage extends BasePage {

    private By checkoutInfoPageTitle = By.cssSelector("span[data-test='title']");
    private By firstNameField = By.cssSelector("input[data-test='firstName']");
    private By lastNameField = By.cssSelector("input[data-test='lastName']");
    private By zipCodeField = By.cssSelector("input[data-test='postalCode']");
    private By continueButton = By.cssSelector("input[data-test='continue']");
    private By errorMessage = By.cssSelector("h3[data-test='error']");


    public CheckoutInfoPage(WebDriver driver) {
        super(driver);
    }

    public String getCheckoutInfoPageTitle() {
        return find(checkoutInfoPageTitle).getText();
    }

    public void inputFirstName(String firstName) {
        input(firstNameField, firstName);
    }

    public void inputLastName(String lastName) {
        input(lastNameField, lastName);
    }

    public void inputZipCode(String zipCode) {
        input(zipCodeField, zipCode);
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }

    public CheckoutOverviewPage clickContinueButton() {
        click(continueButton);
        return new CheckoutOverviewPage(driver);
    }
}