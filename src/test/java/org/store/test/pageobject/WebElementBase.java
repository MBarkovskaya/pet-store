package org.store.test.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.store.test.model.ProductItem;

import java.time.Duration;
import java.util.List;

public class WebElementBase {
    protected final WebDriver webDriver;

    public WebElementBase(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public static String getAttributeTextContent(WebElement element) {
        return element.getAttribute("textContent").trim();
    }

    public static List<ProductItem> getProductItemList(List<WebElement> webElements, By itemNameLocator, By itemPriceLocator) {
        return webElements.stream()
                .map(w -> new ProductItem(w.findElement(itemNameLocator).getAttribute("textContent").trim(),
                        w.findElement(itemPriceLocator).getAttribute("textContent").trim())).toList();
    }

    public void actionsPause(long durationOfSeconds) {
        new Actions(webDriver)
                .pause(java.time.Duration.ofSeconds(durationOfSeconds))
                .perform();
    }

    public JavascriptExecutor jsExecutor() {
        return (JavascriptExecutor) webDriver;
    }

    public WebElement findElementByLocator(By locator, Long durationOfSeconds) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(durationOfSeconds))
                .until(driver -> driver.findElement(locator));
    }

    /*
    I didn't investigate what is wrong with jsExecutor().executeScript("arguments[0].scrollIntoView(true);", element),
    but this method doesn't work properly to scroll to element, at least for the site being tested.
    To force method working I use this workaround with
    actions.moveToElement and for catch - execute JS script.
    I think there is some issue on the site and this is the reason why it happens.
    */
    public void scrollDownToElementAndClick(WebElement element) {
        try {
            Actions actions = new Actions(webDriver);
            actions.moveToElement(element);
            actions.perform();
            scrollUp();
            element.click();
        } catch (ElementClickInterceptedException ex) {
            jsExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
            actionsPause(2L);
            element.click();
        }
    }

    public void scrollUp() {
        jsExecutor().executeScript("window.scrollBy(0,100)", "");
    }

    public Boolean isPresent(By locator) {
        return webDriver.findElements(locator).size() > 0;
    }

    public void clickClearAndSendKey(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

}
