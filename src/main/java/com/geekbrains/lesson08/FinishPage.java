package com.geekbrains.lesson08;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FinishPage {
    
    private final SelenideElement finishButton = $(By.id("finish"));
    private final SelenideElement completeMessageFinishPage =
            $(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));

    @Step("Подтверждение заказа")
    public void clickFinishButton() {
        finishButton.click();
    }

    public FinishPage successfullOrder() {
        completeMessageFinishPage.shouldBe(Condition.text("Checkout: Complete!"));
        return this;
    }
}
