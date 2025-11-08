package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends WebDriverAbst{

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/main/div/div[1]/div/a")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }
}
