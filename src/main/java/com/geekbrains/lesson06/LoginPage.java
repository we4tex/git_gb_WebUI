package com.geekbrains.lesson06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage fillLogin(String login) {
        loginInput.sendKeys(login);
        return this;
    }

    public LoginPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public ProductsPage clickLoginButton() {
        loginButton.click();
        return new ProductsPage(driver);
    }
}
