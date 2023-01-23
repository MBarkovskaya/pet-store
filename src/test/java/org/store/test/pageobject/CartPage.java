package org.store.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.store.test.model.ProductItem;

import java.util.List;

import static org.store.test.pageobject.BaseMethods.clickOnElement;
import static org.store.test.pageobject.Page.cartPageElement;

public class CartPage {
    public List<ProductItem> getProductItemList(List<WebElement> webElements) {
        return webElements.stream()
                .map(w -> new ProductItem(w.findElement(By.cssSelector("h2")).getAttribute("textContent").trim(),
                        w.findElement(By.cssSelector("span.arial-font")).getAttribute("textContent").trim())).toList();
    }

    public void removeItemFromCart(ProductItem productItem) {
        clickOnElement(cartPageElement().removeProductFromCart(productItem.getName()));
    }

}
