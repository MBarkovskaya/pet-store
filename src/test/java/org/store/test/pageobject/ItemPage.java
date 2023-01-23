package org.store.test.pageobject;

import org.store.test.model.ItemsAndItemsNumberInCart;
import org.store.test.model.ProductItem;

import static org.store.test.pageobject.BaseMethods.clickOnElement;
import static org.store.test.pageobject.Page.itemPageElement;

public class ItemPage {
    public void addItemAndBackToShopping(ProductItem item, ItemsAndItemsNumberInCart itemsAndItemsNumberInCart) {
        clickOnElement(itemPageElement().addToTheBasketButton());
        itemsAndItemsNumberInCart.getProductItemList().add(item);
        backToShopping();
    }

    public void backToShopping() {
        clickOnElement(itemPageElement().backToTheShoppingButton());
    }
}
