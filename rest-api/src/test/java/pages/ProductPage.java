package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends WebDriverAbst{

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div[2]/main/div/ul/li[1]/div[1]/a/img")
    WebElement firstProductAddToCart;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/main/div/div[2]/div[2]/form/button")
    WebElement addProduct;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div/div/main/div/div[1]/div/a")
    WebElement goToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addFirstProductToCart() {
        firstProductAddToCart.click();
    }

    public void addProduct(){
        addProduct.click();
    }

    public void goToCart() {
        goToCartButton.click();
    }
}
