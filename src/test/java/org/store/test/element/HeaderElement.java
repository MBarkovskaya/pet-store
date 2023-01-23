package org.store.test.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.store.test.pageobject.BaseMethods.findElementByLocator;

public class HeaderElement {
    public WebElement cartTitleElement() {
        return findElementByLocator(
                By.xpath("//div[@class='nav-top-band']//child::li[@class='cart-nav']"), 0L);
    }
}
