package tests;

import pages.ContactFormPOM;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ContactTests {

    static WebDriver driver;
    static ContactFormPOM contactForm;

    @BeforeAll
    static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        contactForm = new ContactFormPOM(driver);
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    @DisplayName("Wypełnienie i wysłanie formularza kontaktowego DesignValue.pl")
    void testContactFormSubmission() throws InterruptedException {
        driver.get("https://designvalue.pl/kontakt");
        Thread.sleep(2000);

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
