package org.store.test.assertion;

import org.openqa.selenium.By;
import org.store.test.model.ProductItem;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.store.test.pageobject.BaseMethods.isPresent;

public class Assertions {
    public void areResultTextsEquals(SoftAssert softly, String actualValue, String expectedValue) {
        softly.assertEquals(actualValue, expectedValue, "Element has wrong title");
    }

    public void areCollectionEquals(SoftAssert softly, List<ProductItem> productItemsFromProductListPage,
                                    List<ProductItem> productItemsFromCartPage) {
        softly.assertTrue(productItemsFromCartPage.containsAll(productItemsFromProductListPage),
                "Elements of the collections don't match");
    }

    public void collectionDoesNotContainElement(SoftAssert softly, ProductItem removedProductItem,
                                                List<ProductItem> productItemsAfter) {
        softly.assertFalse(productItemsAfter.contains(removedProductItem),
                "Removed element is in collection");
    }

    public void isEachCollectionElementContainsText(SoftAssert softly, List<ProductItem> productItems, String text) {
        for (ProductItem item : productItems) {
            softly.assertTrue(item.getName().contains(text), "Element doesn't contain text: " + text);
        }
        softly.assertAll();
    }

    public void isElementOnThePage(SoftAssert softly, By locator) {
        softly.assertTrue(isPresent(locator));
    }

    public void isElementAbsentOnThePage(SoftAssert softly, By locator) {
        softly.assertFalse(isPresent(locator));
    }

}
