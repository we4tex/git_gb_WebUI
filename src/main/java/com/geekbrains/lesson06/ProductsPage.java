package com.geekbrains.lesson06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addProduct;

    public ProductsPage clickAddProduct() {
        addProduct.click();
        return this;
    }

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cardButton;

    public CardPage clickCardButton() {
        cardButton.click();
        return new CardPage(driver);
    }

}
