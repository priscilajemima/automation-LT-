package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProductsPage {
    private WebDriver browser;

    public String nameItem;
    public String nameCartItem;

    public ProductsPage(WebDriver browser) {
        this.browser = browser;
    }

    public ProductsPage addAProductInTheCart() {
        browser.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String nameItem = browser.findElement(By.cssSelector("#item_4_title_link > div")).getText();
        browser.findElement(By.cssSelector("#shopping_cart_container > a")).click();
        String nameCartItem = browser.findElement(By.cssSelector("#item_4_title_link > div")).getText();

        if (nameItem.equals(nameCartItem)) {
            System.out.println("The two strings are equal.");
        } else {
            System.out.println("The two strings are not equal.");
        }
        return this;
    }

    public ProductsPage finishTheOrder() {
        //compare name Products
        browser.findElement(By.id("checkout")).click();
        String checkoutTitle = browser.findElement(By.cssSelector("#header_container > div.header_secondary_container > span")).getText();
        Assertions.assertEquals("CHECKOUT: YOUR INFORMATION", checkoutTitle);

        //fill the form
        browser.findElement(By.id("first-name")).sendKeys("First Name");
        browser.findElement(By.id("last-name")).sendKeys("Last Name");
        browser.findElement(By.id("postal-code")).sendKeys("0557845");
        browser.findElement(By.id("continue")).click();

        //checkout page
        String checkoutOverviewTitle = browser.findElement(By.cssSelector("#header_container > div.header_secondary_container > span")).getText();
        Assertions.assertEquals("CHECKOUT: OVERVIEW", checkoutOverviewTitle);
        String nameItemCheckout = browser.findElement(By.cssSelector("#item_4_title_link > div")).getText();
        Assertions.assertEquals("Sauce Labs Backpack", nameItemCheckout);

        //finish order
        browser.findElement(By.id("finish")).click();
        String orderCompleted = browser.findElement(By.cssSelector("#checkout_complete_container > h2")).getText();
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", orderCompleted);

        return this;
    }
}










