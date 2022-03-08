package com.geekbrains.lesson07;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends BasePage {

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "finish")
    public WebElement finishButton;

    @Step("Подтверждение заказа")
    public void clickFinishButton() {
        finishButton.click();
    }
}
