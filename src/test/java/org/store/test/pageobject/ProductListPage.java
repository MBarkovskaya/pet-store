package org.store.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.store.test.model.ItemsAndItemsNumberInCart;
import org.store.test.model.ProductItem;

import java.util.Comparator;
import java.util.List;

import static org.store.test.pageobject.BaseMethods.*;
import static org.store.test.pageobject.Page.*;

public class ProductListPage {
    public void selectProductCategory(String categoryId) {
        clickOnElement(productListPageElement().selectCategoriesButton());
        selectCheckboxCategory(productListPageElement().checkboxCategoryById(categoryId));
    }

    public void selectCheckboxCategory(WebElement element) {
        if (element.isEnabled()) {
            element.click();
        }
    }

    public ItemsAndItemsNumberInCart putProductListIntoTheBasket(List<ProductItem> list) {
        String cartItemsNumber;
        ItemsAndItemsNumberInCart itemsAndItemsNumberInCart = new ItemsAndItemsNumberInCart();
        clickOnElement(productListPageElement().sortByFilter());
        clickOnElement(productListPageElement().sortByHighToLow());
        for (ProductItem item:list) {
            scrollDownToElementAndClick(productListPageElement().itemTitle(item.getPrice(), item.getName()));
            if (isPresent(By.cssSelector("span.out-of-stock"))) {
                String textContent = headerElement().cartTitleElement().getAttribute("textContent").trim();
                cartItemsNumber = textContent.substring(0, textContent.indexOf(" "));
                itemsAndItemsNumberInCart.setItemsNumber(cartItemsNumber);
                itemPage().backToShopping();
            } else {
                itemPage().addItemAndBackToShopping(item, itemsAndItemsNumberInCart);
            }
        }
        return itemsAndItemsNumberInCart;
    }

    public List<ProductItem> getLimitedAttributePriceListInDescendingOrder(List<WebElement> webElementsList, long number) {
        return webElementsList.stream()
                .map(w -> new ProductItem(w.findElement(By.cssSelector("h3")).getAttribute("textContent").trim(),
                        w.findElement(By.cssSelector("h4")).getAttribute("textContent").trim()))
                .sorted(Comparator.reverseOrder()).limit(number).toList();
    }

    public void openCartPage() {
        clickOnElement(headerElement().cartTitleElement());
    }

    public void searchForItem(String text) {
        clickClearAndSendKey(productListPageElement().searchItemTextArea(), text);
        clickOnElement(productListPageElement().searchItemButton());
    }

}
