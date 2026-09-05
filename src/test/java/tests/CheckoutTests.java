package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.CartsPage;
import pages.CheckoutCompletePage;
import pages.CheckoutInfoPage;
import pages.CheckoutOverviewPage;
import pages.LoginPage;
import pages.ProductsPage;

// Arrange–Act–Assert 

public class CheckoutTests extends BaseTest {

    private LoginPage login;
    private ProductsPage product;
    private CartsPage cart;
    private CheckoutInfoPage checkoutInfo;
    private CheckoutOverviewPage checkoutOverview;
    private CheckoutCompletePage checkoutComplete;

    private static final String ALL_EMPTY_FIELDS_ERROR = "Error: First Name is required";
    private static final String MISSING_LAST_NAME_ERROR = "Error: Last Name is required";
    private static final String MISSING_ZIPCODE_ERROR = "Error: Postal Code is required";
    private static final String THANK_YOU_MESSAGE = "Thank you for your order!";
    
    @BeforeEach 
    public void setupCheckoutPage() {
        login = new LoginPage(driver);
        product = new ProductsPage(driver);
        cart = new CartsPage(driver);
        checkoutInfo = new CheckoutInfoPage(driver);
        checkoutOverview = new CheckoutOverviewPage(driver);
        checkoutComplete = new CheckoutCompletePage(driver);

        login.inputUsername("standard_user");
        login.inputPassword("secret_sauce");
        login.clickLoginButton();

        product.addItemToCart("Sauce Labs Backpack");
        product.goToCart();

        cart.gotoCheckout();
    }

    @Test 
    public void testCheckoutFormError_AllEmptyFields() {

        // Arrange - done by @beforeeach

        // Act
        checkoutInfo.clickContinueButton();

        // Assert 
        Assertions.assertEquals(ALL_EMPTY_FIELDS_ERROR, checkoutInfo.getErrorMessage());
    }

    @Test 
    public void testCheckoutFormError_MissingLastName() {

        // Arrange - done by @beforeeach

        // Act
        checkoutInfo.inputFirstName("John");
        checkoutInfo.clickContinueButton();

        // Assert 
        Assertions.assertEquals(MISSING_LAST_NAME_ERROR, checkoutInfo.getErrorMessage());
    }

    @Test 
    public void testCheckoutFormError_MissingZipCode() {

        // Arrange - done by @beforeeach

        // Act
        checkoutInfo.inputFirstName("John");
        checkoutInfo.inputLastName("Doe");
        checkoutInfo.clickContinueButton();

        // Assert 
        Assertions.assertEquals(MISSING_ZIPCODE_ERROR, checkoutInfo.getErrorMessage());
    }

    @Test 
    public void testCheckoutPriceCalculation() {

        // Arrange - done by @beforeeach
        
        // Act
        checkoutInfo.inputFirstName("John");
        checkoutInfo.inputLastName("Doe");
        checkoutInfo.inputZipCode("11111");
        checkoutInfo.clickContinueButton();

        double subtotal = checkoutOverview.getSubtotal();
        double tax = checkoutOverview.getTax();
        double total = checkoutOverview.getTotal();

        double totalPrice = subtotal + tax;

        // Assert 
        Assertions.assertEquals(totalPrice, total, 0.001);
    }

    @Test 
    public void testFullCheckoutFlow() {

        // Arrange - done by @beforeeach

        // Act
        checkoutInfo.inputFirstName("John");
        checkoutInfo.inputLastName("Doe");
        checkoutInfo.inputZipCode("11111");
        checkoutInfo.clickContinueButton();

        checkoutOverview.clickFinishButton();

        // Assert 
        Assertions.assertEquals(THANK_YOU_MESSAGE, checkoutComplete.getThankYouMessage());
    }

    @Test 
    public void testCancelButton() {

        // Arrange - done by @beforeeach

        // Act
        checkoutInfo.inputFirstName("John");
        checkoutInfo.inputLastName("Doe");
        checkoutInfo.inputZipCode("11111");
        checkoutInfo.clickContinueButton();

        checkoutOverview.clickCancelButton();

        // Assert 
        Assertions.assertEquals("Products", product.getProductsPageTitle());
    }

    @Test 
    public void testBackHomeButton() {

        // Arrange - done by @beforeeach

        // Act
        checkoutInfo.inputFirstName("John");
        checkoutInfo.inputLastName("Doe");
        checkoutInfo.inputZipCode("11111");
        checkoutInfo.clickContinueButton();

        checkoutOverview.clickFinishButton();
        
        checkoutComplete.clickBackHomeButton();

        // Assert 
        Assertions.assertEquals("Products", product.getProductsPageTitle());
    }
}