package org.store.test.pageobject.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.store.test.pageobject.WebElementBase;

public class HomePageElement extends WebElementBase {
    public HomePageElement(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement shopCategoryHeadElement() {
        return webDriver.findElement(By.xpath("//div[@class='http://shop.bbpetstop.com']//h1"));
    }
    public WebElement rewardsCategoryHeadElement() {
        return webDriver.findElement(By.xpath("//div[@class='home-pet-care']//h1"));
    }
    public WebElement petsCategoryHeadElement() {
        return webDriver.findElement(By.xpath("//div[@class='home-pets']//h1"));
    }
    public WebElement fishCategoryHeadElement() {
        return webDriver.findElement(By.xpath("//div[@class='home-daylillies']//h1"));
    }
}
