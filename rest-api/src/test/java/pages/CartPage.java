package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends WebDriverAbst{

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/main/article/div/div/div[2]/div/div/a")
    WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }
}
