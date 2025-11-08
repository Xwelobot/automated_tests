package pages;

import org.openqa.selenium.WebDriver;

public class WebDriverAbst {

    protected WebDriver driver;

    public WebDriverAbst(WebDriver driver) {
        this.driver = driver;
    }
}
