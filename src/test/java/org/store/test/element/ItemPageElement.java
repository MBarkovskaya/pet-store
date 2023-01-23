package org.store.test.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.store.test.driver.DriverHolder.getDriver;

public class ItemPageElement {

    public WebElement addToTheBasketButton() {
        return getDriver().findElement(By.cssSelector("button.add-cart-btn"));
    }

    public WebElement backToTheShoppingButton() {
        return getDriver().findElement(By.cssSelector("button.back-btn"));
    }

//    public WebElement viewCartMessage() {
//        return getDriver().findElement(By.cssSelector("#messages a > b"));
//    }
    public WebElement outOfStock() {
        return getDriver().findElement(By.cssSelector("span.out-of-stock"));
    }
}
