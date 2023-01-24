package org.store.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.store.test.AppManager;
import org.store.test.model.ItemsAndItemsNumberInCart;
import org.store.test.model.ProductItem;
import org.store.test.pageobject.element.HeaderElement;
import org.store.test.pageobject.element.ProductListPageElement;

import java.util.Comparator;
import java.util.List;

public class ProductListPage extends HeaderElement {

    private ProductListPageElement element;

    public ProductListPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductListPageElement element() {
        if (element == null) {
            element = new ProductListPageElement(webDriver);
        }
        return element;
    }

    public void selectProductCategory(String categoryId) {
        element().selectCategoriesButton().click();
        selectCheckboxCategory(element().checkboxCategoryById(categoryId));
    }

    public void selectCheckboxCategory(WebElement element) {
        if (element.isEnabled()) {
            element.click();
        }
    }

    public ItemsAndItemsNumberInCart putProductListIntoTheBasket(List<ProductItem> list) {
        String cartItemsNumber;
        ItemsAndItemsNumberInCart itemsAndItemsNumberInCart = new ItemsAndItemsNumberInCart();
        element().sortByFilter().click();
        element().sortByHighToLow().click();
        for (ProductItem item:list) {
            scrollDownToElementAndClick(element().itemTitle(item.getPrice(), item.getName()));
            if (isPresent(By.cssSelector("span.out-of-stock"))) {
                String textContent = cartTitleElement().getAttribute("textContent").trim();
                cartItemsNumber = textContent.substring(0, textContent.indexOf(" "));
                itemsAndItemsNumberInCart.setItemsNumber(cartItemsNumber);
                AppManager.pm().itemPage().backToShopping();
            } else {
                AppManager.pm().itemPage().addItemAndBackToShopping(item, itemsAndItemsNumberInCart);
            }
        }
        return itemsAndItemsNumberInCart;
    }

    public List<ProductItem> getLimitedAttributePriceListInDescendingOrder(long number) {
        return element.itemsList().stream()
                .map(w -> new ProductItem(w.findElement(By.cssSelector("h3")).getAttribute("textContent").trim(),
                        w.findElement(By.cssSelector("h4")).getAttribute("textContent").trim()))
                .sorted(Comparator.reverseOrder()).limit(number).toList();
    }

    public void openCartPage() {
        cartTitleElement().click();
    }

    public void searchForItem(String text) {
        clickClearAndSendKey(element().searchItemTextArea(), text);
        element().searchItemButton().click();
    }

}
