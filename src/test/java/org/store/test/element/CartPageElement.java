package org.store.test.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.store.test.driver.DriverHolder.getDriver;

public class CartPageElement {
    public List<WebElement> itemsList() {
        return getDriver().findElements(By.cssSelector("div.cart-info-box"));
    }

    public WebElement proceedToCheckoutButton() {
        return getDriver().findElement(By.cssSelector("#add-cart-btn"));
    }
    public WebElement removeProductFromCart(String productName) {
        return getDriver()
                .findElement(By.xpath(
                        String.format("//a[text()='%s']/ancestor::div[@class='cart-item']//a[@aria-label='Remove product from cart']", productName)));
    }

    public WebElement youCartIsEmptyMessage() {
        return getDriver().findElement(By.cssSelector("#content_inner p"));
    }

    public WebElement continueShoppingButton() {
        return getDriver().findElement(By.cssSelector("#content_inner a.btn.brand-bg-green"));
    }
}
