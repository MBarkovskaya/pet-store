package org.store.test.assertion;

import org.openqa.selenium.By;
import org.store.test.model.ProductItem;
import org.store.test.pageobject.WebElementBase;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Assertions{
    public static void areResultTextsEquals(SoftAssert softly, String actualValue, String expectedValue) {
        softly.assertEquals(actualValue, expectedValue, "Element has wrong title");
    }

    public static void areCollectionEquals(SoftAssert softly, List<ProductItem> productItemsFromProductListPage,
                                    List<ProductItem> productItemsFromCartPage) {
        softly.assertTrue(productItemsFromCartPage.containsAll(productItemsFromProductListPage),
                "Elements of the collections don't match");
    }

    public static void collectionDoesNotContainElement(SoftAssert softly, ProductItem removedProductItem,
                                                List<ProductItem> productItemsAfter) {
        softly.assertFalse(productItemsAfter.contains(removedProductItem),
                "Removed element is in collection");
    }

    public static void isEachCollectionElementContainsText(SoftAssert softly, List<ProductItem> productItems, String text) {
        for (ProductItem item : productItems) {
            softly.assertTrue(item.getName().contains(text), "Element doesn't contain text: " + text);
        }
        softly.assertAll();
    }

    public static void isElementOnThePage(WebElementBase page, SoftAssert softly, By locator) {
        softly.assertTrue(page.isPresent(locator));
    }

    public static void isElementAbsentOnThePage(WebElementBase page, SoftAssert softly, By locator) {
        softly.assertFalse(page.isPresent(locator));
    }

}
