package com.geekbrains.lesson06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    public WebElement firstNameInput;

    public CheckoutPage fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    @FindBy(id = "last-name")
    public WebElement lastNameInput;

    public CheckoutPage fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;

    public CheckoutPage fillPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
        return this;
    }

    @FindBy(id = "continue")
    public WebElement purchaseButton;

    public FinishPage clickPurchaseButton() {
        purchaseButton.click();
        return new FinishPage(driver);
    }

}
