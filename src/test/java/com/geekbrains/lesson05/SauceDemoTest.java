package com.geekbrains.lesson05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SauceDemoTest {

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
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user-name"))));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    @DisplayName("Negative: Incomplete Authorization")
    void incompleteAuthorization () {
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user-name"))));
        driver.findElement(By.id("user-name")).sendKeys("standard_er");
        driver.findElement(By.id("password")).sendKeys("secret_sce");
        driver.findElement(By.id("login-button")).click();
        Assertions.assertFalse(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    @DisplayName("Positive: Complete Order")
    void completeOrder () {
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user-name"))));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driverWait.until((ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")))));
        driver.findElement((By.id("add-to-cart-sauce-labs-backpack"))).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("checkout"))));
        driver.findElement(By.id("checkout")).click();
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("first-name"))));
        driver.findElement(By.id("first-name")).sendKeys("User");
        driver.findElement((By.id("last-name"))).sendKeys("Standart");
        driver.findElement((By.id("postal-code"))).sendKeys("00000");
        driver.findElement(By.id("continue")).click();
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish"))));
        driver.findElement(By.id("finish")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
