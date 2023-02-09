package pages;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public LoginPage sendUser(String user) {
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        return this;
    }

    public LoginPage sendPassword(String password) {
        browser.findElement(By.id("password")).sendKeys("secret_sauce");
        return this;
    }

    public LoginPage submit() {
        browser.findElement(By.id("login-button")).click();
        return this;
    }

    public ProductsPage validateTitle() {
        String titlePage = browser.findElement(By.cssSelector("#header_container > div.header_secondary_container > span")).getText();
        Assertions.assertEquals("PRODUCTS", titlePage);
        return new ProductsPage(browser);
    }
}

