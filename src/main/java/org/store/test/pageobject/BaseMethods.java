package org.store.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.store.test.model.ProductItem;

import java.time.Duration;
import java.util.List;

import static org.store.test.driver.DriverHolder.getDriver;

public class BaseMethods {
    public static JavascriptExecutor js = (JavascriptExecutor) getDriver();

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    public static WebElement findElementByLocator(By locator, Long durationOfSeconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(durationOfSeconds))
                .until(driver -> driver.findElement(locator));
    }

    public static String getAttributeTextContent(WebElement element) {
        return element.getAttribute("textContent").trim();
    }

    public static void scrollDownToElementAndClick(WebElement element) {
        try {
            Actions actions = new Actions(getDriver());
            actions.moveToElement(element);
            actions.perform();
            scrollUp();
            element.click();
        } catch (ElementClickInterceptedException ex) {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            actionsPause(2L);
            element.click();
        }
    }

    public static void scrollUp() {
        js.executeScript("window.scrollBy(0,100)", "");
    }

    public static void actionsPause(long durationOfSeconds) {
        new Actions(getDriver())
                .pause(java.time.Duration.ofSeconds(durationOfSeconds))
                .perform();
    }

    public static Boolean isPresent(By locator) {
        return getDriver().findElements(locator).size() > 0;
    }

    public static List<ProductItem> getProductItemList(List<WebElement> webElements, By itemNameLocator, By itemPriceLocator) {
        return webElements.stream()
                .map(w -> new ProductItem(w.findElement(itemNameLocator).getAttribute("textContent").trim(),
                        w.findElement(itemPriceLocator).getAttribute("textContent").trim())).toList();
    }

    public static void clickClearAndSendKey(WebElement element, String text) {
        element.click();
        element.clear();
        element.sendKeys(text);
    }

}
