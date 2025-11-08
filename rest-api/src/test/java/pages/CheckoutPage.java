package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends WebDriverAbst{

    @FindBy(id = "name")
    WebElement nameInput;

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "address")
    WebElement addressInput;

    @FindBy(id = "place-order")
    WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillOrderForm(String name, String email, String address) {
        nameInput.sendKeys(name);
        emailInput.sendKeys(email);
        addressInput.sendKeys(address);
    }

    public void placeOrder() {
        placeOrderButton.click();
    }
}
