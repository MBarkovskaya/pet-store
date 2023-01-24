package org.store.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.store.test.model.ProductItem;
import org.store.test.pageobject.element.CartPageElement;
import org.store.test.pageobject.element.HeaderElement;

import java.util.List;

public class CartPage extends HeaderElement {
    private CartPageElement element;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CartPageElement element() {
        if (element == null) {
            element = new CartPageElement(webDriver);
        }
        return element;
    }


    public List<ProductItem> getProductItemList() {
        return element().itemsList().stream()
                .map(w -> new ProductItem(w.findElement(By.cssSelector("h2")).getAttribute("textContent").trim(),
                        w.findElement(By.cssSelector("span.arial-font")).getAttribute("textContent").trim())).toList();
    }

    public void removeItemFromCart(ProductItem productItem) {
        element().removeProductFromCart(productItem.getName()).click();
    }

}
