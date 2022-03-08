package com.geekbrains.lesson08;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private final SelenideElement loginInput = $(By.id("user-name"));
    private final SelenideElement passwordInput = $(By.id("password"));
    private final SelenideElement loginButton = $(By.id("login-button"));
    private final SelenideElement titleLoginPage =
            $(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
    private final SelenideElement errorMessageLoginPage =
            $(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));

    @Step("Вводится логин")
    public LoginPage fillLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Вводится логин")
    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Вводится логин")
    public ProductsPage clickLoginButton() {
        loginButton.click();
        return page(ProductsPage.class);
    }

    @Step("Пользователь успешно авторизовался")
    public LoginPage completeAuthorization() {
        titleLoginPage.shouldBe(Condition.text("PRODUCTS"));
        return this;
    }

    @Step("Пользователь не авторизовался")
    public LoginPage incorrectAuthorization() {
        errorMessageLoginPage.shouldBe(Condition.text("Epic sadface: Username and password " +
                "do not match any user in this service"));
        return this;
    }

}
