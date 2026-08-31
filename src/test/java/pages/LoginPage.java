package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By usernameField = By.cssSelector("input[data-test='username']");
    private By passwordField = By.cssSelector("input[data-test='password']");
    private By loginButton = By.cssSelector("input[data-test='login-button']");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    // getter, setter, transition, convinience 

    public void inputUsername(String username) {
        input(usernameField, username);
    }

    public void inputPassword(String password) {
        input(passwordField, password);
    }

    public ProductsPage clickLoginButton() {
        click(loginButton);
        return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return find(errorMessage).getText();
    }

    public ProductsPage logIntoProductsPage(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        return clickLoginButton();
    }
}