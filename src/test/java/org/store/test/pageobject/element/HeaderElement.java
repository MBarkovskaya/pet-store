package org.store.test.pageobject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.store.test.pageobject.WebElementBase;
public class HeaderElement extends WebElementBase {
    public HeaderElement(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement cartTitleElement() {
        return findElementByLocator(
                By.xpath("//div[@class='nav-top-band']//child::li[@class='cart-nav']"), 0L);
    }
}
