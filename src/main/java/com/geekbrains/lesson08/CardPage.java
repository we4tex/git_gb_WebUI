package com.geekbrains.lesson08;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CardPage {

    private final SelenideElement checkoutButton = $(By.id("checkout"));

    @Step("Переход к заполнению информации")
    public CheckoutPage clickCheckoutButton() {
        checkoutButton.click();
        return page(CheckoutPage.class);
    }

}
