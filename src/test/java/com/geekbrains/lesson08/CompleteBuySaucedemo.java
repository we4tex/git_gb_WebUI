package com.geekbrains.lesson08;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompleteBuySaucedemo {
    @When("Пользователь успешно авторизовывается")
    public void userCompleteAuth() {
        Selenide.open("https://saucedemo.com");
        new LoginPage()
                .fillLogin("standard_user")
                .fillPassword("secret_sauce")
                .clickLoginButton();
    }

    @When("Пользователь добавляет продукт в корзину и переходит в нее")
    public void userAddProducts() {
        new ProductsPage()
                .clickAddProducts()
                .clickCardButton();
    }

    @When("Пользователь проверяет заказ и переходит к странице заполнения данных")
    public void userGoToDataText() {
        new CardPage()
                .clickCheckoutButton();
    }

    @When("Пользователь добавляет данные и переходит на страницу подтверждения")
    public void userInputData() {
        new CheckoutPage()
                .fillFirstName("User")
                .fillLastName("Lastname")
                .fillPostalCode("00000")
                .clickPurchaseButton();
    }

    @When("Пользователь подтверждает заказ")
    public void userPlaceOrders() {
        new FinishPage()
                .clickFinishButton();
    }

    @Then("Пользователь успешно совершил покупку")
    public void userSuccessfullOrder() {
        new FinishPage()
                .successfullOrder();
    }

    @After(value = "@close_browser")
    public void after() {
        Selenide.closeWebDriver();
    }
}
