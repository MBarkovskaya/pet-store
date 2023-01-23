package org.store.test.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.store.test.driver.DriverHolder.getDriver;

public class HomePageElement {
    public WebElement shopCategoryHeadElement() {
        return getDriver().findElement(By.xpath("//div[@class='http://shop.bbpetstop.com']//h1"));
    }
    public WebElement rewardsCategoryHeadElement() {
        return getDriver().findElement(By.xpath("//div[@class='home-pet-care']//h1"));
    }
    public WebElement petsCategoryHeadElement() {
        return getDriver().findElement(By.xpath("//div[@class='home-pets']//h1"));
    }
    public WebElement fishCategoryHeadElement() {
        return getDriver().findElement(By.xpath("//div[@class='home-daylillies']//h1"));
    }
    public WebElement shopCategoryElement() {
        return getDriver().findElement(By.xpath("//div[@class='http://shop.bbpetstop.com']"));
    }
}
