package com.geekbrains.lesson06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishPage extends BasePage{

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "finish")
    public WebElement finishButton;

    public void clickFinishButton() {
        finishButton.click();
    }
}
