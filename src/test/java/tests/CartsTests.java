package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.CartsPage;
import pages.CheckoutInfoPage;
import pages.LoginPage;
import pages.ProductsPage;

// Arrange–Act–Assert 

public class CartsTests extends BaseTest {

    LoginPage login;
    ProductsPage product;
    CartsPage cart;
    CheckoutInfoPage checkout;

    private static final String ITEM_TO_TEST = "Sauce Labs Backpack";
    private static final String CHECKOUT_TITLE = "Checkout: Your Information";
    private static final String PRICE_TO_TEST = "$29.99";

    @BeforeEach
    public void setupCartsPage() {
        login = new LoginPage(driver);
        product = new ProductsPage(driver);
        cart = new CartsPage(driver);
        checkout = new CheckoutInfoPage(driver);

        login.inputUsername("standard_user");
        login.inputPassword("secret_sauce");
        login.clickLoginButton();

        product.addItemToCart(ITEM_TO_TEST);
        product.goToCart();
    }

    @Test
    public void testItemNameInCart() {

        // Arrange - done by @beforeeach

        // Act - done by @beforeeach

        // Assert 
        Assertions.assertEquals(ITEM_TO_TEST, cart.getItemName());
    }

    @Test
    public void testItemPriceInCart() {

        // Arrange - done by @beforeeach

        // Act - done by @beforeeach
        
        // Assert
        Assertions.assertEquals(PRICE_TO_TEST, cart.getItemPrice());
    }

    @Test
    public void testCheckoutButton() {

        // Arrange - done by @beforeeach

        // Act
        cart.gotoCheckout();
        
        // Assert
        Assertions.assertEquals(CHECKOUT_TITLE, checkout.getCheckoutInfoPageTitle());
    }
}