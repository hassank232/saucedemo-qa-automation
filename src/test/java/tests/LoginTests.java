package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import pages.LoginPage;
import pages.ProductsPage;

// Arrange–Act–Assert 

public class LoginTests extends BaseTest {

    LoginPage login;
    ProductsPage product;

    private static final String LOCKED_OUT_ERROR = "Epic sadface: Sorry, this user has been locked out.";
    private static final String INVALID_ERROR = "Epic sadface: Username and password do not match any user in this service";

    @BeforeEach
    public void setupLoginPage() {
        login = new LoginPage(driver);
        product = new ProductsPage(driver);
    }

    @DisplayName("CSV filesource - Tests for login page")
    @ParameterizedTest
    @CsvFileSource(resources = "/data/login_data.csv", numLinesToSkip = 1)
    public void testLogin(String username, String password, String expectedResult) {

        // arrange done by @beforeeach

        // act
        login.inputUsername(username);
        login.inputPassword(password);
        login.clickLoginButton();

        // assert (expected, actual)
        if(expectedResult.equals("success")) {
            Assertions.assertEquals("Products", product.getProductsPageTitle());
        }
        else if(expectedResult.equals("locked_out_error")) {
            Assertions.assertEquals(LOCKED_OUT_ERROR, login.getErrorMessage());
        }
        else {
            Assertions.assertEquals(INVALID_ERROR, login.getErrorMessage());
        }
    }
}