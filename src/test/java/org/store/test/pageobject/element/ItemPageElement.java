package org.store.test.pageobject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.store.test.pageobject.WebElementBase;

public class ItemPageElement extends WebElementBase {

    public ItemPageElement(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement addToTheBasketButton() {
        return webDriver.findElement(By.cssSelector("button.add-cart-btn"));
    }

    public WebElement backToTheShoppingButton() {
        return webDriver.findElement(By.cssSelector("button.back-btn"));
    }
}
