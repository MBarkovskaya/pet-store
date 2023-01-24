package org.store.test.pageobject;

import org.openqa.selenium.WebDriver;
import org.store.test.pageobject.element.HeaderElement;
import org.store.test.pageobject.element.HomePageElement;
import org.store.test.util.PropertyFileReader;

public class HomePage extends HeaderElement {
    private HomePageElement element;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void navigate() {
        webDriver.navigate().to(PropertyFileReader.getProperty("siteurl"));
    }

    public void openProductListPage() {
        scrollDownToElementAndClick(element().shopCategoryHeadElement());
    }

    public HomePageElement element() {
        if (element == null) {
            element = new HomePageElement(webDriver);
        }
        return element;
    }

}
