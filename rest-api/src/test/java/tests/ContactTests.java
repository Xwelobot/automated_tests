package tests;

import pages.ContactFormPOM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ContactTests {

    static WebDriver driver;
    static ContactFormPOM contactForm;
    static HomePage homePage;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://designvalue.pl/kontakt");
        homePage = new HomePage(driver);
        contactForm = new ContactFormPOM(driver);
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    @DisplayName("Wypełnienie i wysłanie formularza kontaktowego DesignValue.pl")
    void testContactFormSubmission() throws InterruptedException {
        homePage.acceptCookiesIfVisible();
        contactForm.enterName("Jan Kowalski");
        contactForm.enterEmail("jan.kowalski@example.com");
        contactForm.enterSubject("Zapytanie testowe");
        contactForm.enterMessage("To jest test automatyczny formularza kontaktowego.");

        contactForm.submitForm();

        Thread.sleep(3000);
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Dziękujemy") || pageSource.contains("wysłano"),
                "Nie znaleziono potwierdzenia wysłania formularza!");
    }
    //test dziala, wylaczony jest przycisk w ktorym nalezy zaznaczyc zapoznanie sie z polityka prywatnosci
}
