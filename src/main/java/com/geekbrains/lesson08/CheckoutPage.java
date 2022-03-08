package com.geekbrains.lesson08;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CheckoutPage {

    private final SelenideElement firstNameInput = $(By.id("first-name"));
    private final SelenideElement lastNameInput = $(By.id("last-name"));
    private final SelenideElement postalCodeInput = $(By.id("postal-code"));
    private final SelenideElement purchaseButton = $(By.id("continue"));

    @Step("Вводится имя")
    public CheckoutPage fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    @Step("Вводится фамилия")
    public CheckoutPage fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    @Step("Вводится почтовый код")
    public CheckoutPage fillPostalCode(String postalCode) {
        postalCodeInput.sendKeys(postalCode);
        return this;
    }

    @Step("Подтверждение ввода информации")
    public FinishPage clickPurchaseButton() {
        purchaseButton.click();
        return page(FinishPage.class);
    }

}
