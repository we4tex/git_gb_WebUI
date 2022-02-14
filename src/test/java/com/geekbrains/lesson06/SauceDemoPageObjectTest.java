package com.geekbrains.lesson06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SauceDemoPageObjectTest {

    WebDriver driver;
    WebDriverWait driverWait;
    public static final String URL = "https://www.saucedemo.com/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get(URL);
    }

    @Test
    @DisplayName("Positive: Complete Authorization")
    void completeAuthorization () {
        new LoginPage(driver).fillLogin("standard_user")
                .fillPassword("secret_sauce")
                .clickLoginButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    @DisplayName("Negative: Incomplete Authorization")
    void incompleteAuthorization () {
        new LoginPage(driver).fillLogin("standard_user")
                .fillPassword("negative_test")
                .clickLoginButton();
        Assertions.assertFalse(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    @DisplayName("Positive: Complete Order")
    void completeOrder () {
        new LoginPage(driver).fillLogin("standard_user")
                .fillPassword("secret_sauce")
                .clickLoginButton()
                .clickAddProduct()
                .clickCardButton()
                .clickCheckoutButton()
                .fillFirstName("User")
                .fillLastName("Standart")
                .fillPostalCode("00000")
                .clickPurchaseButton()
                .clickFinishButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
