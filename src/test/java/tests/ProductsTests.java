package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.LoginPage;
import pages.ProductsPage;

// Arrange–Act–Assert 

public class ProductsTests extends BaseTest {

    LoginPage login;
    ProductsPage product;
    
    @BeforeEach
    public void setupProductsPage() {
        login = new LoginPage(driver);
        product = new ProductsPage(driver);

        login.inputUsername("standard_user");
        login.inputPassword("secret_sauce");
        login.clickLoginButton();
    }

    @Test
    public void testAddToCart() {

        //Arrange - done by @beforeeach

        // Act
        product.addItemToCart("Sauce Labs Backpack");

        // Assert (expected, actual)
        Assertions.assertEquals(1, product.getCartCount());
    }

    @Test
    public void testRemoveFromCart() {

        // Arrange - done by @beforeeach

        // Act
        product.addItemToCart("Sauce Labs Backpack");
        product.removeItemFromCart("Sauce Labs Backpack");

        // Assert
        Assertions.assertEquals(0, product.getCartCount());
    }    
}