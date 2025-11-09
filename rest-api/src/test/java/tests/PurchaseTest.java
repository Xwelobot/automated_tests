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

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("Dodanie produktu do koszyka oraz zakup")
    void shouldAddProductToCart() {
        homePage.acceptCookiesIfVisible();
        homePage.openProducts();
        productPage.addFirstProductToCart();
        productPage.addProduct();
        productPage.goToCart();
        cartPage.proceedToCheckout();
        checkoutPage.fillOrderForm("Jan", "Kowalski", "jan@example.com","ul. Testowa 12","88-999","Warszawa","666777888");
        checkoutPage.placeOrder();

        String pageSource = driver.getPageSource();
        assertTrue(
                pageSource.contains("Twoja wiadomość została wysłana. Dziękujemy!"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
