package org.store.test.pageobject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.store.test.pageobject.WebElementBase;

import java.util.List;

public class CartPageElement extends WebElementBase {
    public CartPageElement(WebDriver webDriver) {
        super(webDriver);
    }

    public List<WebElement> itemsList() {
        return webDriver.findElements(By.cssSelector("div.cart-info-box"));
    }

    public WebElement proceedToCheckoutButton() {
        return webDriver.findElement(By.cssSelector("#add-cart-btn"));
    }
    public WebElement removeProductFromCart(String productName) {
        return webDriver
                .findElement(By.xpath(
                        String.format("//a[text()='%s']/ancestor::div[@class='cart-item']//a[@aria-label='Remove product from cart']", productName)));
    }

    public WebElement youCartIsEmptyMessage() {
        return   webDriver.findElement(By.cssSelector("#content_inner p"));
    }

    public WebElement continueShoppingButton() {
        return  webDriver.findElement(By.cssSelector("#content_inner a.btn.brand-bg-green"));
    }
}
