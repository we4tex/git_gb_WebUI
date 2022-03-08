package com.geekbrains.lesson08;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProductsPage {

    private final SelenideElement addProduct = $(By.id("add-to-cart-sauce-labs-backpack"));
    private final SelenideElement cardButton = $(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));

    @Step("Добавление товара в корзину")
    public ProductsPage clickAddProducts() {
        addProduct.click();
        return this;
    }

    @Step("Переход в корзину")
    public CardPage clickCardButton() {
        cardButton.click();
        return page(CardPage.class);
    }

}
