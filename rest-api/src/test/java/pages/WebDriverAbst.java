package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebDriverAbst {

    protected WebDriver driver;

    public WebDriverAbst(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
