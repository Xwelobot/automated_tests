package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebDriverAbst{

    @FindBy(xpath = "/html/body/div[1]/header/div[1]/div/div/div/div/div[1]/div[1]/div/div/nav/div/ul/li[3]/a")
    WebElement productsMenu;

    @FindBy(id = "hu-cookies-save")
    WebElement acceptCookiesButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openProducts() {
        productsMenu.click();
    }

    public void acceptCookiesIfVisible() {
        try {
            if (acceptCookiesButton.isDisplayed()) {
                acceptCookiesButton.click();
                Thread.sleep(1000); // krótka pauza, aż zniknie
            }
        } catch (Exception ignored) {
            // brak banera = nic nie robimy
        }
    }
}
