package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends WebDriverAbst{

    @FindBy(id = "billing_first_name")
    WebElement nameInput;

    @FindBy(id = "billing_last_name")
    WebElement lastnameInput;

    @FindBy(id = "billing_postcode")
    WebElement postaddressInput;

    @FindBy(id = "billing_city")
    WebElement cityInput;

    @FindBy(id = "billing_phone")
    WebElement numberInput;

    @FindBy(id = "billing_email")
    WebElement emailInput;

    @FindBy(id = "billing_address_1")
    WebElement addressInput;

    @FindBy(id = "place_order")
    WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillOrderForm(String name,String lastname, String email, String address, String postaddress, String city, String number) {
        nameInput.sendKeys(name);
        lastnameInput.sendKeys(lastname);
        postaddressInput.sendKeys(postaddress);
        cityInput.sendKeys(city);
        numberInput.sendKeys(number);
        emailInput.sendKeys(email);
        addressInput.sendKeys(address);
    }

    public void placeOrder() {
        placeOrderButton.click();
    }
}
