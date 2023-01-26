package org.store.test.pageobject;

import org.openqa.selenium.WebDriver;
import org.store.test.model.ItemsAndItemsNumberInCart;
import org.store.test.model.ProductItem;
import org.store.test.pageobject.element.HeaderElement;
import org.store.test.pageobject.element.ItemPageElement;

public class ItemPage extends HeaderElement {

    private ItemPageElement element;
    public ItemPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ItemPageElement element() {
        if (element == null) {
            element = new ItemPageElement(webDriver);
        }
        return element;
    }

    public void addItemAndBackToShopping(ProductItem item, ItemsAndItemsNumberInCart itemsAndItemsNumberInCart) {
        element().addToTheBasketButton().click();
        itemsAndItemsNumberInCart.getProductItemList().add(item);
        addItemsNumberToResultModel(itemsAndItemsNumberInCart);
        backToShopping();
    }

    public void backToShopping() {
        element().backToTheShoppingButton().click();
    }
}
