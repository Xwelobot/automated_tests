package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PurchaseTest {

    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://designvalue.pl/");

        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    @Order(1)
    @DisplayName("Dodanie produktu do koszyka")
    void shouldAddProductToCart() {
        homePage.openProducts();
        productPage.addFirstProductToCart();
        productPage.goToCart();
    }

    @Test
    @Order(2)
    @DisplayName("Zakup produktu z koszyka")
    void shouldProceedToCheckoutAndAttemptPurchase() {
        cartPage.proceedToCheckout();
        checkoutPage.fillOrderForm("Jan Kowalski", "jan@example.com", "Warszawa, ul. Testowa 12");
        checkoutPage.placeOrder();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
