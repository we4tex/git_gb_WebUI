package com.geekbrains.lesson03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Сценарий из Задания №1: "Совершение успешной покупки на сайте https://www.saucedemo.com/
 * Доступ: Логин ~ standard_user; пароль ~ secret_sauce
 * Данные для покупки: First name - User; Last user ~ Standart; Zip ~ 00000
 */

public class MainSaucedemo {

    public static void main(String[] args) throws InterruptedException {

        //Add DriverChrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Step 1: Authorization
        driver.get("https://www.saucedemo.com/");
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user-name"))));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        //Step 2: Add products for cart
        webDriverWait.until((ExpectedConditions.visibilityOf(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")))));
        driver.findElement((By.id("add-to-cart-sauce-labs-backpack"))).click();
        //Step 3: Go to Cart
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        //Step 4: Go to Checkout: Your information
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("checkout"))));
        driver.findElement(By.id("checkout")).click();
        //Step 5: Data entry for the purchase
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("first-name"))));
        driver.findElement(By.id("first-name")).sendKeys("User");
        driver.findElement((By.id("last-name"))).sendKeys("Standart");
        driver.findElement((By.id("postal-code"))).sendKeys("00000");
        //Step 6: Go to Checkout: overview
        driver.findElement(By.id("continue")).click();
        //Step 7: Thank you for your order
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish"))));
        driver.findElement(By.id("finish")).click();
        //Step 8: Logout this site
        driver.findElement(By.id("react-burger-menu-btn")).click();
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("logout_sidebar_link"))));
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(3000);  // Сan be removed
        driver.quit();

    }

}
