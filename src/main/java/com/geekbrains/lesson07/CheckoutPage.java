package com.geekbrains.lesson07;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    public WebElement firstNameInput;

//    @Step("Вводится имя")
    public CheckoutPage fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    @FindBy(id = "last-name")
    public WebElement lastNameInput;

//    @Step("Вводится фамилия")
    public CheckoutPage fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;

//    @Step("Вводится почтовый код")
    public CheckoutPage fillPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
        return this;
    }

    @FindBy(id = "continue")
    public WebElement purchaseButton;

//    @Step("Подтверждение ввода информации")
    public FinishPage clickPurchaseButton() {
        purchaseButton.click();
        return new FinishPage(driver);
    }

}
