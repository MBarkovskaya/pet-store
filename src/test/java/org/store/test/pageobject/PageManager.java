package org.store.test.pageobject;

import org.openqa.selenium.WebDriver;
import org.store.test.pageobject.element.*;

public class PageManager {

    private final WebDriver webDriver;

    private HomePage homePage;

    private ProductListPage productListPage;

    private CartPage cartPage;
    private ItemPage itemPage;

    public PageManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(webDriver);
        }
        return homePage;
    }

    public ProductListPage productListPage() {
        if (productListPage == null) {
            productListPage = new ProductListPage(webDriver);
        }
        return productListPage;
    }

    public CartPage cartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(webDriver);
        }
        return cartPage;
    }

    public ItemPage itemPage() {
        if (itemPage == null) {
            itemPage = new ItemPage(webDriver);
        }
        return itemPage;
    }
}
