package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebDriverAbst{

    @FindBy(className = "menu-link")
    WebElement productsMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openProducts() {
        productsMenu.click();
    }
}
