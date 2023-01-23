package org.store.test.pageobject;

import org.store.test.assertion.Assertions;
import org.store.test.element.*;

public class Page {
    private static HeaderElement headerElement;
    private static HomePage homePage;
    private static HomePageElement homePageElement;
    private static ProductListPage productListPage;
    private static ProductListPageElement productListPageElement;
    private static Assertions assertions;
    private static CartPage cartPage;
    private static CartPageElement cartPageElement;
    private static ItemPage itemPage;
    private static ItemPageElement itemPageElement;
    public static HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }
    public static HomePageElement homePageElement() {
        if (homePageElement == null) {
            homePageElement = new HomePageElement();
        }
        return homePageElement;
    }
    public static ProductListPage productListPage() {
        if (productListPage == null) {
            productListPage = new ProductListPage();
        }
        return productListPage;
    }
    public static ProductListPageElement productListPageElement() {
        if (productListPageElement == null) {
            productListPageElement = new ProductListPageElement();
        }
        return productListPageElement;
    }
    public static Assertions assertions() {
        if (assertions == null) {
            assertions = new Assertions();
        }
        return assertions;
    }

    public static CartPage cartPage() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }
        return cartPage;
    }

    public static CartPageElement cartPageElement() {
        if (cartPageElement == null) {
            cartPageElement = new CartPageElement();
        }
        return cartPageElement;
    }

    public static ItemPage itemPage() {
        if (itemPage == null) {
            itemPage = new ItemPage();
        }
        return itemPage;
    }

    public static ItemPageElement itemPageElement() {
        if (itemPageElement == null) {
            itemPageElement = new ItemPageElement();
        }
        return itemPageElement;
    }

    public static HeaderElement headerElement() {
        if (headerElement == null) {
            headerElement = new HeaderElement();
        }
        return headerElement;
    }

}
