package com.geekbrains.lesson08;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorAuthorizationSaucedemo {

    @When("Пользователь вводит некорректный логин")
    public void userEnterErrorLogin() {
        new LoginPage().fillLogin("_user");
    }

    @When("Пользователь вводит некорректный пароль")
    public void userEnterErrorPass() {
        new LoginPage().fillPassword("sauce");
    }

    @Then("Пользователь не авторизовался на сайте")
    public void userIncompleteAuthorization() {
        new LoginPage().incorrectAuthorization();
    }

    @After(value = "@close_browser")
    public void after() {
        Selenide.closeWebDriver();
    }
}
