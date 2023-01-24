package org.store.test.pageobject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.store.test.pageobject.WebElementBase;

import java.util.List;

public class ProductListPageElement extends WebElementBase {
    public ProductListPageElement(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement shopAllButtonElement() {
        return findElementByLocator(By.cssSelector("div.main-hover-navbar li.shop-now"), 0L);
    }

    public WebElement selectCategoriesButton() {
        return findElementByLocator(By.cssSelector("#category-select"), 0L);
    }

    public WebElement checkboxCategoryById(String id) {
        return webDriver.findElement(By.xpath(String.format("//label[@for='%s']", id)));
    }

    public WebElement productItemNestedElement(int nestingLevel) {
        return findElementByLocator(
                By.cssSelector(String.format("div.row.breadcrumbs ul a:nth-child(%s)", nestingLevel)), 0L);
    }

    public List<WebElement> itemsList() {
        return webDriver.findElements(By.cssSelector("div.product-list-box"));
    }

    public WebElement itemTitle(String price, String itemName) {
        return webDriver.findElement(By.xpath(String.format("//h4[contains(text(), '%s')]" +
                "/ancestor::div[@class='prdct-detail-box']/h3[@title='%s']", price, itemName)));
    }

    public WebElement sortByFilter() {
        return webDriver.findElement(By.cssSelector("div.filter-option"));
    }

    public WebElement sortByHighToLow() {
        return webDriver.findElement(By.xpath("//*[@id='filterdiv']//span[contains(text(), 'High to Low')]"));
    }

    public WebElement searchItemTextArea() {
        return webDriver.findElement(By.xpath("//input[@type='text' and @name='query']"));
    }

    public WebElement searchItemButton() {
        return webDriver.findElement(By.cssSelector("i#inner_search.flaticon-search"));
    }

}
