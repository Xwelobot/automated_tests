package com.tobol;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactFormPOM {

    // Imię i nazwisko
    @FindBy(name = "your-name")
    WebElement nameInput;

    // Adres e-mail
    @FindBy(name = "your-email")
    WebElement emailInput;

    // Temat wiadomości
    @FindBy(name = "your-subject")
    WebElement subjectInput;

    // Treść wiadomości
    @FindBy(name = "your-message")
    WebElement messageInput;

    // Przycisk "Wyślij"
    @FindBy(xpath = "/html/body/div[1]/div/div/div/main/article/div/div/section[2]/div/div[2]/div/div[3]/div/div/div/form/p[5]/small/input")
    WebElement submitButton;


    public ContactFormPOM(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterSubject(String theme) {
        subjectInput.clear();
        subjectInput.sendKeys(theme);
    }

    public void enterMessage(String message) {
        messageInput.clear();
        messageInput.sendKeys(message);
    }

    public void submitForm() {
        submitButton.click();
    }
}
