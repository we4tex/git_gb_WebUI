package com.geekbrains.lesson08;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompleteAuthorizationSaucedemo {
    @Given("^Пользователь находится на сайте saucedemo.com$")
    public void userGoToWeb() {
        Selenide.open("https://saucedemo.com");
    }

    @When("^Пользователь вводит корректный логин$")
    public void userEnterLogin() {
        new LoginPage().fillLogin("standard_user");
    }

    @When("^Пользователь вводит корректный пароль$")
    public void userEnterPass() {
        new LoginPage().fillPassword("secret_sauce");
    }

    @When("^Пользователь нажимает кнопку Войти$")
    public void userClickLoginButton() {
        new LoginPage().clickLoginButton();
    }

    @Then("^Пользователь успешно авторизовался$")
    public void userCompleteAuthorization() {
        new LoginPage().completeAuthorization();
    }

    @After(value = "@close_browser")
    public void after() {
        Selenide.closeWebDriver();
    }

}
