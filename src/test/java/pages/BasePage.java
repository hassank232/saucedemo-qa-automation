package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    // constructor to initialize driver 
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // find the element
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    // what to input
    protected void input(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    // click the button
    protected void click(By locator) {
        find(locator).click();
    } 
}